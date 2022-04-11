package AlohaFood;

import java.util.Scanner;

abstract class OrderType {
	String OrderID;
	String CustomerName;
	String MenuID;
	int MenuQuantity;
	String OrderType;
	String DeliveryAddress;
	String TakeAwayPickerName;
	int OrderTotalPrice;

	abstract void inputMenuQuantity(Scanner scanner);
	abstract void inputOrderType(Scanner scanner);
	abstract String generateOrderID();
	abstract void getOrderId();
	abstract int generateTotalPrice(int MenuPrices);
	abstract void getTotalPrice(int MenuPrices);
}
