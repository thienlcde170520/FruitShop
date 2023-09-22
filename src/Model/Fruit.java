package Model;
public class Fruit {
	private int quantity;
	private String name, origin, id;
	private double price;
	public Fruit(String id, int price, int quantity, String name, String origin) {
		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.name = name;
		this.origin = origin;
	}
	public Fruit(String id, double price, String name, String origin) {
		this.id = id;
		this.price = price;
		this.name = name;
		this.origin = origin;
	}
	public Fruit(Fruit that) {
		this(that.getId(), that.getPrice(), that.getName(), that.getOrigin());
	}
	public Fruit() {
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	
}
