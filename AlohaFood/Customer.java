package AlohaFood;

import java.util.Scanner;
import java.util.Vector;

public class Customer extends OrderType{

	public Customer() {
		super();
	}
	
	protected void getMenuID(String MenuID) {
		this.MenuID = MenuID;
	}
	
	private boolean checkMenuQuantity(String MenuQuantity) {
		int panjang = MenuQuantity.length();
		
		for (int i = 0; i < panjang; i++) {
			if(MenuQuantity.charAt(0) == '-') {
				return false;
			}
			if(!(MenuQuantity.charAt(i) >= 48 && MenuQuantity.charAt(i) <= 57)) {
				return false;
			}
		}
		
		return true;
	}
	
	String MenusQuantity;
	@Override
	void inputMenuQuantity(Scanner scanner) {
		do {
			System.out.print("Input Quantity (Must be Numeric) : ");
			MenusQuantity = scanner.nextLine();
		}while(!checkMenuQuantity(MenusQuantity));
		this.MenuQuantity = Integer.parseInt(MenusQuantity);
	}
	
	private boolean checkOrderType(String OrderType) {
		if(OrderType.equalsIgnoreCase("Delivery") || OrderType.equalsIgnoreCase("Takeaway")) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	void inputOrderType(Scanner scanner) {
		do {
			System.out.print("Input Order Type [Delivery | Takeaway](Case Insensitive): ");
			this.OrderType = scanner.nextLine();
		}while(!checkOrderType(this.OrderType));
		this.OrderType = this.OrderType.toLowerCase();
        String firstLetter = this.OrderType.substring(0, 1);
        String remainingLetters = this.OrderType.substring(1, this.OrderType.length());
        firstLetter = firstLetter.toUpperCase();
        this.OrderType = firstLetter.concat(remainingLetters);
        
        if(this.OrderType.equals("Delivery")) {
        	inputDeliveryAddress(scanner);
        }else if(this.OrderType.equals("Takeaway")) {
        	inputPickerName(scanner);
        }
	}
	
	private boolean validateDeliveryAddress(String Address) {
		if(Address.startsWith("Jl. ") || Address.startsWith("Jln. ") || Address.startsWith("Jalan ")) {
			return true;
		}else {
			return false;
		}
	}
	
	void inputDeliveryAddress(Scanner scanner) {
		do{
			System.out.print("Input Delivery Address : ");
			this.DeliveryAddress = scanner.nextLine();
		}while(!validateDeliveryAddress(this.DeliveryAddress));
	}
	
	private boolean validatePickerName(String PickerName) {
		if (PickerName.length() >= 5 && PickerName.length() <= 20){
            return true;
        }
        return false;
	}
	
	void inputPickerName(Scanner scanner) {
		do{
			System.out.print("Input Picker Name [5 - 20 characters] : ");
			this.TakeAwayPickerName = scanner.nextLine();
		}while(!validatePickerName(this.TakeAwayPickerName));
	}
	
	int LoopID = 1;
	@Override
	String generateOrderID() {
		String OrdersID;
		OrdersID = String.format("OR%03d",LoopID);
		LoopID = LoopID + 1;
		
		return OrdersID;
	}

	@Override
	void getOrderId() {
		this.OrderID = generateOrderID();
	}

	@Override
	int generateTotalPrice(int MenuPrices) {
		int TotalPrices;
		int MenusPrices;
		
		MenusPrices = MenuPrices;
		TotalPrices = this.MenuQuantity * MenusPrices;
		
		return TotalPrices;
	}
	
	@Override
	void getTotalPrice(int MenuPrices) {
		this.OrderTotalPrice = generateTotalPrice(MenuPrices);
	}
	
	void getCustomerName(String NamaCustomer) {
		this.CustomerName = NamaCustomer;
	}
	
	Vector<Order> OrderList = new Vector<>();
	
	void insertOrder() {
		OrderList.add(new Order(this.OrderID, this.MenuID, this.MenuQuantity, this.OrderType, this.DeliveryAddress, this.TakeAwayPickerName, this.OrderTotalPrice, this.CustomerName));
	}
	
	public Vector<Order> getOrder() {
		return OrderList;
	}
}
