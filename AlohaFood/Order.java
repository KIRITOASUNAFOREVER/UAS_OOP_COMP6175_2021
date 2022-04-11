package AlohaFood;

public class Order {
	String OrderID;
	String MenuID;
	int MenuQuantity;
	String OrderType;
	String DeliveryAddress;
	String TakeAwayPickerName;	
	int OrderTotalPrice;
	String CustomerName;
	
	public Order(String orderID, String menuID, int menuQuantity, String orderType, String deliveryAddress,
			String takeAwayPickerName, int orderTotalPrice, String customerName) {
		super();
		OrderID = orderID;
		MenuID = menuID;
		MenuQuantity = menuQuantity;
		OrderType = orderType;
		DeliveryAddress = deliveryAddress;
		TakeAwayPickerName = takeAwayPickerName;
		OrderTotalPrice = orderTotalPrice;
		CustomerName = customerName;
	}

	public String getOrderID() {
		return OrderID;
	}

	public void setOrderID(String orderID) {
		OrderID = orderID;
	}

	public String getMenuID() {
		return MenuID;
	}

	public void setMenuID(String menuID) {
		MenuID = menuID;
	}

	public int getMenuQuantity() {
		return MenuQuantity;
	}

	public void setMenuQuantity(int menuQuantity) {
		MenuQuantity = menuQuantity;
	}

	public String getOrderType() {
		return OrderType;
	}

	public void setOrderType(String orderType) {
		OrderType = orderType;
	}

	public String getDeliveryAddress() {
		return DeliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		DeliveryAddress = deliveryAddress;
	}

	public String getTakeAwayPickerName() {
		return TakeAwayPickerName;
	}

	public void setTakeAwayPickerName(String takeAwayPickerName) {
		TakeAwayPickerName = takeAwayPickerName;
	}

	public int getOrderTotalPrice() {
		return OrderTotalPrice;
	}

	public void setOrderTotalPrice(int orderTotalPrice) {
		OrderTotalPrice = orderTotalPrice;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
}
