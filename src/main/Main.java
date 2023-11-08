package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.Noodles;
import model.Original;
import model.Spicy;

public class Main {
	Scanner s = new Scanner(System.in);
	ArrayList<Noodles> nList = new ArrayList<>();
	Random rand = new Random();
	public Main() {
		while (true) {
			
			int choose;
			System.out.println("1. Add Items");
			System.out.println("2. View Items");
			System.out.println("3. Delete items");
			System.out.println("4. Exit");
			do {
				System.out.print(">> ");
				choose = s.nextInt();
			} while (choose < 1 || choose > 4);
			switch (choose) {
			case 1:
				add();
				break;

			case 2:
				view();
				break;

			case 3:
				Delete();
				break;

			case 4:
				System.exit(0);
				break;

			}
		}
	}
	
	void add() {
		String type;
		do {
			System.out.print("Type : ");
			type = s.nextLine();
		} while (!type.equals("Original") && !type.equals("Spicy"));
		
		String name;
		do {
			System.out.print("Name : ");
			name = s.nextLine();
		} while (name.length() <= 5 || name.length() >= 25);
		
		
		
		int price;
		do {
			System.out.print("Price : ");
			price = s.nextInt();s.nextLine();
		} while (price < 10000 || price > 100000);
		
		int quantity;
		do {
			System.out.print("Quantity : ");
			quantity = s.nextInt();s.nextLine();
		} while (quantity <=0);
		
		String id = String.format("%s%s%s%d%d", name.replaceAll(" ", "").toUpperCase().charAt(rand.nextInt(name.length())),
				name.replaceAll(" ", "").toUpperCase().charAt(rand.nextInt(name.length())),
				name.replaceAll(" ", "").toUpperCase().charAt(rand.nextInt(name.length())),
				rand.nextInt(9+1),rand.nextInt(9+1));
		

		
		if (type.equals("Original")) {
			String broth;
			do {
				System.out.print("broth : ");
				broth = s.nextLine();
			} while (!broth.equals("Mild") && !broth.equals("Normal") && !broth.equals("Savory"));
			

			
			Noodles o = new Original(name, price, quantity, id, broth);
			nList.add(o);
		}else if (type.equals("Spicy")) {
			int lvlspicy;
			do {
				System.out.print("level : ");
				lvlspicy = s.nextInt();s.nextLine();
			} while (lvlspicy < 1 || lvlspicy > 5);
			
			
			Noodles s = new Spicy(name, price, quantity, id, lvlspicy);
			nList.add(s);
		}
		
	}
	
	void view() {
		if (nList.isEmpty()) {
			System.out.println("Kosong");
			System.out.println(" ");
			System.out.println(" ");
		}else {
			System.out.println("=======================================================================================");
			System.out.printf("|%-10s|%-25s|%-10s|%-10s|%-10s|%-15s|\n","ID","Name","Price","Stock","Broth Type","Spicy Level");
			System.out.println("=======================================================================================");
			for (int i = 0; i < nList.size(); i++) {
				Noodles n = nList.get(i);
				
				if (n instanceof Original) {
					System.out.printf("|%-10s|%-25s|%-10s|%-10s|%-10s|%-15s|\n",n.getId(),n.getName(),n.Hitung(),n.getQuantity(),((Original)n).broth," - ");
					
				}else if (n instanceof Spicy) {
					System.out.printf("|%-10s|%-25s|%-10s|%-10s|%-10s|%-15s|\n",n.getId(),n.getName(),n.Hitung(),n.getQuantity()," - ",((Spicy) n).lvlspicy);
					
				}
			}
			System.out.println("=======================================================================================");
		}
	}
	
	void Delete() {
		if (nList.isEmpty()) {
			System.out.println("Kosong");
			System.out.println(" ");
			System.out.println(" ");
		}else {
			view();
			
			String choose;
			
			boolean found = false;
			
			while (found == false) {
				System.out.print("Input ID : ");
				choose = s.nextLine();
				
				for (int i = 0; i < nList.size(); i++) {
					
					if (choose.equals(nList.get(i).getId())) {
						nList.remove(i);
						found = true;
					}
				}
				

			}
			
			
		}
	}

	public static void main(String[] args) {
		new Main();

	}

}
