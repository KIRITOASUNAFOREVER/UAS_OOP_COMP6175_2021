package AlohaFood;

import java.util.Scanner;

abstract class MenuType {
	String MenuID;
	String MenuName;
	int MenuPrice;
	
	abstract void inputMenuName(Scanner scanner);
	abstract void inputMenuPrice(Scanner scanner);
	abstract String generateMenuID();
	abstract void getMenuId();
}
