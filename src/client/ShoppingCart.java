package client;

import java.util.LinkedList;

/**
 * 
 * @author Andrew Stallone ShoppingCart class that holds items for checkout
 */

public class ShoppingCart {

	private LinkedList<Item> shoppingCart = new LinkedList<Item>();

	public ShoppingCart() {

	}

	/**
	 * getList
	 * 
	 * @return returns the list of items in the shopping cart
	 * 
	 */
	public LinkedList<Item> getList() {
		return shoppingCart;
	}

	/**
	 * addItem
	 * 
	 * @param Item
	 *            to be added to the list if the shopping cart already contains
	 *            this item it increments the quantity counter.
	 */
	public void addItem(Item i) {

		if (shoppingCart.contains(i)) {
			i.setAmountInCart(i.getAmountInCart() + 1);
		} else {
			shoppingCart.add(i);
			i.setAmountInCart(i.getAmountInCart() + 1);
		}

	}

	/**
	 * removeItem
	 * 
	 * @param Item
	 *            to be removed to the list if the shopping cart is empty
	 *            nothing happens otherwise the item is removed.
	 */
	public void removeItem(Item i) {
		if (!shoppingCart.isEmpty()) {
			shoppingCart.remove(i);
		}
	}

	/**
	 * getSubtotal
	 * 
	 * for each item in the shopping cart the price is added to get the total.
	 * 
	 * @return subtotal
	 */
	public double getSubtotal() {
		double subtotal = 0.0;
		for (Item i : shoppingCart) {
			subtotal += i.getPrice();
		}
		return subtotal;
	}

	/**
	 * getSubtotal
	 * 
	 * gives the amount of items in the cart.
	 * 
	 * @return size of cart
	 */
	public int getSize() {
		return shoppingCart.size();
	}
}
