package AlohaFood;

import java.util.Scanner;
import java.util.Vector;

public class AlohaFood {
	Scanner scan = new Scanner(System.in);
	Admin admin = new Admin();
	Vector<Menu> menuList = admin.getMenu();
	Customer customer = new Customer();
	Vector<Order> orderList = customer.getOrder();
	
	private boolean checkName(String Name) {
		if(Name.length() >=5 && Name.length()<= 30) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean checkPhoneNumber(String PhoneNumber) {
		int panjang = PhoneNumber.length();
		
		for (int i = 0; i < panjang; i++) {
			if(PhoneNumber.charAt(0) == '-') {
				return false;
			}
			if(!(PhoneNumber.charAt(i) >= 48 && PhoneNumber.charAt(i) <= 57)) {
				return false;
			}
		}
		
		if(panjang == 12) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean checkCredential(String Credential) {
		if(Credential.equalsIgnoreCase("ADMIN") || Credential.equalsIgnoreCase("CUSTOMER")) {
			return true;
		}else {
			return false;
		}
	}
	
	public AlohaFood() {
		HomePage();
	}
	
	private void HomePage() {
		String Name;
		do {
			System.out.print("Input your name [5 - 30 characters]: ");
			Name = scan.nextLine();
		}while(!checkName(Name));
		
		String PhoneNumber;
		do {
			System.out.print("Input your phone number [12 digits](Must be Numeric) : ");
			PhoneNumber = scan.nextLine();
		}while(!checkPhoneNumber(PhoneNumber));
		
		System.out.println();
		
		LoginOption(Name);
	}
	
	private void LoginOption(String Names) {
		String Credential;
		do {
			System.out.print("Input your Credentials [ADMIN | CUSTOMER](Case Insensitive): ");
			Credential = scan.nextLine();
		}while(!checkCredential(Credential));
		Credential = Credential.toUpperCase();
		
		if(Credential.equals("ADMIN")) {
			AdminMenu();
		}else if(Credential.equals("CUSTOMER")) {
			CustomerMenu(Names);
		}
	}
	
	private void AdminMenu() {
		int pilihan;
		
		do {
			System.out.println("1. Add Menu");
			System.out.println("2. Show Order List");
			System.out.println("3. Exit");
			System.out.print(">> ");
			pilihan = scan.nextInt(); scan.nextLine();
			
			switch(pilihan) {
			case 1:
				addMenu();
				break;
			case 2:
				showOrderList();
				break;
			case 3:
				exitAdmin();
				break;
			}
		}while(pilihan < 1 || pilihan > 3 || pilihan != 3);
	}
	
	private void addMenu() {
		admin.inputMenuName(scan);
		admin.inputMenuPrice(scan);
		admin.getMenuId();
		admin.insertMenu();
		
		System.out.println();
		System.out.println("Generated Menu ID    : "+menuList.get(menuList.size()-1).getMenuID());
		
		System.out.println(); System.out.println();
		System.out.println("Menu Successfully Saved!!!");
		System.out.print("Press Enter to continue...");
		scan.nextLine();
	}
	
	private String getMenuName(String MenuID) {
		int jumlah = menuList.size();
		String MenusName = "";
		
		for (int m = 0; m < jumlah; m++) {
			if(menuList.get(m).getMenuID().equals(MenuID)) {
				MenusName = menuList.get(m).getMenuName();
				break;
			}
		}
		
		return MenusName;
	}
	
	private void showOrderList() {
		if(orderList.isEmpty()) {
			System.out.println("No Data");
			System.out.println(); System.out.println();
			System.out.print("Press Enter to continue...");
			scan.nextLine();
			return;
		}else {
			int jumlah = orderList.size();
			String MenuName;
			
			System.out.println("===================================================================================================================================");
			System.out.printf("| %-8s | %-30s | %-30s | %-25s | %-8s | %-11s |\n","Order ID", "Customer Name", "Order Type", "Menu Name", "Quantity", "Total Price");
			System.out.println("===================================================================================================================================");
			for (int k = 0; k < jumlah; k++) {
				MenuName = getMenuName(orderList.get(k).getMenuID());
				System.out.printf("| %-8s | %-30s ",orderList.get(k).getOrderID(), orderList.get(k).getCustomerName());
				if(orderList.get(k).getOrderType().equals("Delivery")) {
					System.out.printf("| %-30s ","D - " +orderList.get(k).getDeliveryAddress());
				}else if(orderList.get(k).getOrderType().equals("Takeaway")) {
					System.out.printf("| %-30s ","T - " +orderList.get(k).getTakeAwayPickerName());
				}
				System.out.printf("| %-25s | %-8d | %-11d |\n",MenuName, orderList.get(k).getMenuQuantity(), orderList.get(k).getOrderTotalPrice());
				System.out.println("===================================================================================================================================");
			}
			
			System.out.println(); System.out.println();
			System.out.print("Press Enter to continue...");
			scan.nextLine();
		}
	}
	
	private void exitAdmin() {
		HomePage();
	}
	
	private void ListofMenu() {
		int jumlah = menuList.size();
		
		System.out.println("=================================================================");
		System.out.printf("| %-15s | %-25s | %-15s |\n","Menu ID", "Menu Name", "Menu Price");
		System.out.println("=================================================================");
		for (int i = 0; i < jumlah; i++) {
			System.out.printf("| %-15s | %-25s | %-15d |\n",menuList.get(i).getMenuID(), menuList.get(i).getMenuName(), menuList.get(i).getMenuPrice());
			System.out.println("=================================================================");
		}
	}
	
	private boolean validateMenuID(String MenuID){
        int jumlah = menuList.size();
        
        for (int i = 0; i < jumlah; i++) {
			if(menuList.get(i).getMenuID().equals(MenuID)) {
				return true;
			}
		}
        
        return false;
    }
	
	private int getMenuIndex(String MenuID){
        int jumlah = menuList.size();
        int tanda = -1;
        
        for (int j = 0; j < jumlah; j++) {
			if(menuList.get(j).getMenuID().equals(MenuID)) {
				tanda = j;
				break;
			}
		}
        
        return tanda;
    }
	
	private void CustomerMenu(String Nama) {
		if(menuList.isEmpty()) {
			System.out.println("No Data");
			System.out.println(); System.out.println();
			System.out.print("Press Enter to continue...");
			scan.nextLine();
			HomePage();
		}else {
			ListofMenu();
			System.out.println();
			String MenuID;
			do{
				System.out.print("Input Menu ID : ");
				MenuID = scan.nextLine();
			}while(!validateMenuID(MenuID));
			
			customer.getMenuID(MenuID);
			customer.inputMenuQuantity(scan);
			customer.inputOrderType(scan);
			customer.getOrderId();
			int indexs;
			indexs = getMenuIndex(MenuID);
			int MenuPrices;
			MenuPrices = menuList.get(indexs).getMenuPrice();
			customer.getTotalPrice(MenuPrices);
			customer.getCustomerName(Nama);
			customer.insertOrder();
			
			System.out.println();
			System.out.println("Order ID    : "+orderList.get(orderList.size()-1).getOrderID());
			System.out.println("Total Price : "+orderList.get(orderList.size()-1).getOrderTotalPrice());
			
			System.out.println(); System.out.println();
			System.out.println("Order Successfully Saved!!!");
			System.out.print("Press Enter to continue...");
			scan.nextLine();
			HomePage();
		}
	}

	public static void main(String[] args) {
		new AlohaFood();
	}
}