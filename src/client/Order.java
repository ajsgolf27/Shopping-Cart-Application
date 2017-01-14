package client;

import java.util.LinkedList;

public class Order {
	private LinkedList<Item> listOfPurchasedProducts = new LinkedList<Item>();
	public Order(){
		
	}
	
	public void addItem(Item i){
		listOfPurchasedProducts.add(i);
	}
	
	public double orderTotal(){
		double total = 0;
		for(Item i : listOfPurchasedProducts){
			total += i.getPrice() * i.getOrderAmount();
		}
		return total * 1.06;
	}
	
	public double totalCost(){
		double total = 0;
		for(Item i : listOfPurchasedProducts){
			total += i.getCost() * i.getOrderAmount();
		}
		return total;
	}
}
