package model;

public class Original extends Noodles {
	public String broth;

	public Original(String name, int price, int quantity, String id,String broth) {
		super(name, price, quantity,id);
		this.broth = broth;
	}

	@Override
	public int Hitung() {
		
		if (broth.equals("Mild") || broth.equals("Normal")) 
			return 1 * price;
		if (broth.equals("Savory")) 
			return (int) (1.5 * price);
		return 0;
	}
	
}
