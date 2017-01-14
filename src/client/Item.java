package client;
/**
 * 
 * @author Andrew Stallone 
 * Item class 
 */
public class Item {
	private String name = "";
	private String description = "";
	private int quantity = 0;
	private double price = 0.0;
	private int amountInCart = 0;
	private double cost = 0;
	private int orderAmount = 0;
	
	/**
	 * Constructor for the Student Object
	 * 
	 * @param name of item
	 * @param description of item 
	 * @param quantity of item
	 * @param price of item
	 * @param cost of item
	 *           
	 */
	public Item(String name, String description, int quantity, double price, double cost){
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.cost = cost;
	}
	
	/**
	 * getOrderAmount
	 * gets the total order amount
	 * @return the amount of the order
	 *           
	 */
	public int getOrderAmount(){return orderAmount;}
	
	/**
	 * setOrderAmount
	 * sets the total order amount
	 *
	 */
	public void setOrderAmount(int orderAmount){
		this.orderAmount = orderAmount;
	}
	
	/**
	 * getCost
	 * gets the cost amount
	 * @return the cost of the item
	 *           
	 */
	public double getCost(){return cost;}
	
	/**
	 * setCost
	 * sets the cost of the item
	 * 	            
	 */
	public void setCost(double cost){
		this.cost = cost;
	}
	
	/**
	 * getAmountInCart
	 * gets the item amount in the cart
	 * @return the amount items in the cart
	 *           
	 */
	public int getAmountInCart(){
		return amountInCart;
	}
	
	/**
	 * setAmountInCart
	 * sets the amount in the cart
	 *
	 *           
	 */
	public void setAmountInCart(int amount){
		amountInCart = amount;
	}
	
	/**
	 * setPrice
	 * sets the price of the item
	 * 
	 *           
	 */
	public void setPrice(double price){
		this.price = price;
	}
	
	/**
	 * getPrice
	 * gets the pice of item
	 * @return the price of the item
	 *           
	 */
	public double getPrice(){
		return price;
	}
	
	/**
	 * setDecscription
	 * sets the description of the item
	 *           
	 */
	public void setDecscription(String description){
		this.description = description;
	}
	
	/**
	 * getDescription
	 * gets the item description
	 * @return description of the item
	 *           
	 */
	public String getDescription(){
		return description;
	}
	
	/**
	 * setitemQuantity
	 * sets the item quantity
	 * 
	 *           
	 */
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	/**
	 * getQuantity
	 * gets the quantity of the item
	 * @return the quantity of the item
	 *           
	 */
	public int getQuantity(){
		return quantity;
	}
	
	/**
	 * getOrderAmount
	 * gets the total order amount
	 * @return the amount of the order
	 *           
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * getName
	 * gets the name of the item
	 * @return the name of the item
	 *           
	 */
	public String getName(){
		return name;
	}
}
