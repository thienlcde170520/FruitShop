package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import Model.IdGenerator;
import view.Validation;
import Model.Fruit;
public class FruitList {
	private ArrayList<Fruit> list = new ArrayList<Fruit>();
	IdGenerator generator = new IdGenerator();
	Validation valid = new Validation();
	
	private HashMap<String, ArrayList<Fruit>> hm = new HashMap<String, ArrayList<Fruit>>();
	ArrayList<Fruit> shop = new ArrayList<Fruit>();
	public FruitList() {
		list.add(new Fruit(generator.generate(), 3, 200, "Mango", "Vietnam" ));
		list.add(new Fruit(generator.generate(), 2, 300, "Melon", "Japan" ));
		list.add(new Fruit(generator.generate(), 4, 350, "Orange", "America" ));
	}
	public void create() {
		
		String name = valid.inputAphabe("Input name: ");
		
		double price = valid.inputPositiveDouble("Input price: ");
		
		String origin = valid.inputAphabe("Input origin: ");
		
		Fruit f = new Fruit(generator.generate(), price, name, origin);
		list.add(f);
		
		if (valid.YerOrNo("Do you want to continue(Y/N)")) {
			create();
		}
		else 
			display();
	}
	public void display() {
		if (list.isEmpty()) 
			System.out.println("The list is empty.");
		else {
			System.out.println("List of fruits:");
			System.out.printf("%-10s%-20s%-20s%-15s\n", "| ++ Item ++ ", "| ++ Fruit name ++ ", "| ++ Origin ++ ", "| ++ Price ++ |");
			for (Fruit f: list) {                            
                            System.out.printf("%-20s%-20s%-20s%-20.2f\n",f.getId(), f.getName(), f.getOrigin(), f.getPrice());                                
                            System.out.println();

			}
		}
	}
	public void shopping(Scanner s) {

		IdGenerator idShop = new IdGenerator();
		boolean loop = true;
		while (loop) {
			String choice = valid.inputStr("Select item: ");
			Fruit item = search(choice);
			
			if (item!=null) {
				Fruit f = new Fruit(item);
				
				int quantity = valid.getQuantity("Select Quantity: ");
				while((item.getQuantity()-quantity) < 0 ) {
					System.out.println("Sorry! We have only "+item.getQuantity()+" left.");
					quantity = valid.getQuantity("Select Quantity: ");
				}
				item.setQuantity(item.getQuantity()-quantity);
				f.setQuantity(quantity);
				
				boolean action = true;
				
				for (Fruit x: shop) {
					if (x.getName().equals(f.getName())) {
						x.setQuantity(quantity+x.getQuantity());
						action = false;
					}
				}
			
				if(action) {
					f.setId(idShop.generate());
					System.out.println();
					shop.add(f);
				}
				
			}
			loop = valid.YerOrNo("Do you want to order now (Y/N)");
		}
		
		String name = valid.inputNameVN("Input customer's name: ");
		viewListOrders(shop);
		
			if(hm.containsKey(name)) {
				int size = hm.get(name).size();
				int id = Integer.valueOf(hm.get(name).get(size-1).getId());
				idShop.init("", "", id);
				for(Fruit x: shop) {
					x.setId(idShop.generate());
				}
				hm.get(name).addAll(shop);
			}
			else
				hm.put(name, shop);
		
		shop = new ArrayList<>();
		
	}
	public Fruit search(String id) {
		for (Fruit f: list) {
			if (f.getId().equals(id)) {
				System.out.println("You select: " + f.getName());
				return f;
			}
		}
		System.out.println("Do not find that item.");
		return null;
	}
	public void viewListOrders(ArrayList<Fruit> shop) {
		int total = 0;
		System.out.println("Product | Quantity | Price | Amount ");
		for (Fruit f: shop) {
			double amount = f.getPrice()*f.getQuantity();
			System.out.println(f.getId()+" "+f.getName()+"     "+f.getQuantity()+"       "+f.getPrice()+"$      "+amount+"$");
			total+= amount;
		}
		System.out.println("Total: "+total+"$");
	}
	public void viewOrders(String name) {
		int total = 0;
		ArrayList<Fruit> viewlist =  hm.get(name);
		System.out.println("Customer: " + name);
		System.out.println("Product | Quantity | Price | Amount ");
		for (Fruit f: viewlist) {
			double amount = f.getPrice()*f.getQuantity();
			System.out.println(f.getId()+" "+f.getName()+"     "+f.getQuantity()+"       "+f.getPrice()+"$      "+amount+"$");
			total+= amount;
		}
		System.out.println("Total: "+total+"$");
	}
	public void viewAllOders() {
		Set<String> keySet = hm.keySet();
		for (String k: keySet) {
			viewOrders(k);
		}
	}
}
