package AlohaFood;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Admin extends MenuType{
	
	public Admin() {
		super();
	}
	
	private boolean validateMenuName(String MenuName){
        if (MenuName.length() >= 5 && MenuName.length() <= 20){
            return true;
        }
        return false;
    }

	@Override
	void inputMenuName(Scanner scanner) {
		do{
			System.out.print("Input Menu Name [5 - 20 characters] : ");
			this.MenuName = scanner.nextLine();
		}while(!validateMenuName(this.MenuName));
	}
	
	
	private boolean validateMenuPrice(int MenuPrice){
        if (MenuPrice >= 10000 && MenuPrice <= 50000){
            return true;
        }
        return false;
    }

	@Override
	void inputMenuPrice(Scanner scanner) {
		do{
			System.out.print("Input Menu Price [10000 - 50000](Must be Numeric) : ");
			this.MenuPrice = scanner.nextInt(); scanner.nextLine();
		}while(!validateMenuPrice(this.MenuPrice));
	}

	@Override
	String generateMenuID() {
		String MenusID;
		Random rand = new Random();
		int number1 = rand.nextInt(10);
		int number2 = rand.nextInt(10);
		int number3 = rand.nextInt(10);
		int number4 = rand.nextInt(10);
		int number5 = rand.nextInt(10);
		int number6 = rand.nextInt(10);
		int number7 = rand.nextInt(10);
		int number8 = rand.nextInt(10);
		int number9 = rand.nextInt(10);
		int number10 = rand.nextInt(10);
		MenusID = String.format("%d%d%d%d%d%d%d%d%d%d",number1, number2, number3, number4, number5, number6, number7, number8, number9, number10);
		
		return MenusID;
	}

	@Override
	void getMenuId() {
		this.MenuID = generateMenuID();
	}
	
	Vector<Menu> MenuList = new Vector<>();
	
	void insertMenu() {
		MenuList.add(new Menu(this.MenuID, this.MenuName, this.MenuPrice));
	}
	
	public Vector<Menu> getMenu() {
		return MenuList;
	}
}
