package client;

import java.util.ArrayList;

/**
 * 
 * @author Andrew Stallone Singleton OrderList class that holds orders
 */

public class OrderList {
	private ArrayList<Order> orderList = new ArrayList<Order>();
	private static OrderList myObj;

	/**
	 * Private Constructor for the OrderList Object
	 * 
	 * 
	 */

	private OrderList() {

	}

	/**
	 * getInstance
	 * 
	 * @return the instance of the class
	 * 
	 * 
	 */

	public static OrderList getInstance() {
		if (myObj == null) {
			myObj = new OrderList();
		}
		return myObj;
	}

	/**
	 * add
	 * 
	 * adds an order to the list
	 * 
	 * 
	 */
	public void add(Order o) {
		orderList.add(o);
	}

	/**
	 * getOrderList
	 * 
	 * @return the list of orders
	 * 
	 * 
	 */
	public ArrayList<Order> getOrderList() {
		return orderList;
	}

	/**
	 * getTotalCost
	 * 
	 * @return the total cost of all items in the list
	 * 
	 * 
	 */
	public double getTotalCost() {
		double cost = 0;
		for (Order o : orderList) {
			cost += o.totalCost();
		}
		return cost;
	}

	/**
	 * getTotalRevenue
	 * 
	 * @return the total revenue of all items in the list
	 * 
	 * 
	 */
	public double getTotalRevenue() {
		double revenue = 0;
		for (Order o : orderList) {
			revenue += o.orderTotal();
		}
		return revenue;
	}

}
