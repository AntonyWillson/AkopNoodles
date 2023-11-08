package model;

public class Spicy extends Noodles {
	public int lvlspicy;

	public Spicy(String name, int price, int quantity,String id, int lvlspicy) {
		super(name, price, quantity,id);
		this.lvlspicy = lvlspicy;
	}

	@Override
	public int Hitung() {
		if (lvlspicy <= 3 && lvlspicy >= 1) 
			return 1 * price;
		if (lvlspicy >= 4 && lvlspicy <=5) 
			return (int) (1.5 * price);
		
		return 0;
	}
	
	

}
