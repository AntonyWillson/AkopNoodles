package model;

public  abstract class Noodles  {
	protected String name;
	protected int price;
	protected int quantity;
	protected String id;
	
	public Noodles(String name, int price, int quantity, String id) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public abstract int Hitung();
	
}
