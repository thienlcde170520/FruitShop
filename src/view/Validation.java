package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Validation {
	Scanner sc = new Scanner(System.in);
	
	public String inputAphabe(String msg) {
		System.out.print(msg);
		String name = sc.nextLine().trim();
		while (!name.matches("^[A-Za-z ]+$")) {
			System.out.println("Please input a valid name!");
			name = sc.nextLine().trim();
		}
		return name;
	}
	public double inputPositiveDouble(String msg) {
		System.out.print(msg);
		String number = sc.nextLine();
		while (!number.matches("-?\\d+([.]\\d+)?")) {
			System.out.println("You must input digit");
			System.out.print(msg);
			number = sc.nextLine();
		}
		if(Double.parseDouble(number)<=0) {
			System.out.println("Digit is greater than zero");
			inputPositiveDouble(msg);
		}
		return Double.parseDouble(number);
	}
	public boolean YerOrNo(String msg) {
		System.out.println(msg);
		
		ArrayList<String> choices = new ArrayList<>();
		choices.add("yes");
		choices.add("y");
		choices.add("no");
		choices.add("n");
		
		String choice = sc.nextLine().trim().toLowerCase();
		while(!choices.contains(choice)) {
			System.out.println("Please input: (yes/y/no/n)");
			System.out.println(msg);
			choice = sc.nextLine().trim().toLowerCase();
		}
		
		if(choice.contains("y")) 
			return true;
		return false;
	}
	public int getQuantity(String msg) {
		String number;
		do {
			System.out.print(msg);
			number = sc.nextLine();
		} while (!number.matches("\\d*") || Integer.valueOf(number) <= 0);
		return Integer.parseInt(number);
	}
	public String inputStr(String msg) {
		System.out.println(msg);
		String data = sc.nextLine().trim();
		return data;
	}
	public String inputNameVN(String msg) {
		System.out.print(msg);
		String name = sc.nextLine().trim();
		while (!name.matches("^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]+$")) {
			System.out.println("Please input a valid name!");
			name = sc.nextLine().trim();
		}
		return name;
	}
}
