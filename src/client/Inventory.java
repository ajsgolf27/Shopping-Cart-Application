package client;

import java.util.ArrayList;

/**
 * 
 * @author Andrew Stallone Inventory Singleton class that holds items
 */
public class Inventory {
	private ArrayList<Item> itemList = new ArrayList<Item>();
	private static Inventory myObj;

	/**
	 * Constructor for the Inventory Object
	 * 
	 * adds 3 items to the list for demo purposes
	 * 
	 */
	private Inventory() {
		itemList.add(new Item("Macbook Pro", "256gb ssd, 16gb ram, 15\" screen", 5, 1999.00, 500.00));
		itemList.add(new Item("iPad Pro", "32gb ssd, 9.7\" screen", 25, 599.00, 200.00));
		itemList.add(new Item("iPad Pro", "32gb ssd, 12.9\" screen", 28, 799.00, 300.00));
		itemList.add(new Item("iPod touch", "16gb ssd holds 5,000 songs", 32, 149.00, 22.50));

	}

	/**
	 * getInstance
	 * 
	 * 
	 * @return a reference to the inventory object
	 */
	public static Inventory getInstance() {
		if (myObj == null) {
			myObj = new Inventory();
		}
		return myObj;
	}

	/**
	 * getList
	 * 
	 * @return the list of items
	 */
	public ArrayList<Item> getList() {
		return itemList;
	}

}
