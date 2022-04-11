package AlohaFood;

public class Menu {
	String MenuID;
	String MenuName;
	int MenuPrice;
	
	public Menu(String menuID, String menuName, int menuPrice) {
		super();
		MenuID = menuID;
		MenuName = menuName;
		MenuPrice = menuPrice;
	}

	public String getMenuID() {
		return MenuID;
	}

	public void setMenuID(String menuID) {
		MenuID = menuID;
	}

	public String getMenuName() {
		return MenuName;
	}

	public void setMenuName(String menuName) {
		MenuName = menuName;
	}

	public int getMenuPrice() {
		return MenuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		MenuPrice = menuPrice;
	}
	
}
