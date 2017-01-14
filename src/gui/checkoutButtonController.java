package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.ShoppingCart;
/**
 * 
 * @author Andrew Stallone 
 * @about ActionListener for the checkout button in the shopping cart view
 */

public class checkoutButtonController implements ActionListener{
	
	private ShoppingCartView shoppingCartView;
	private CustomerView customerView;
	/**
	 * Constructor for the checkoutButtonController Object
	 * 
	 * @param ShoppingCartView
	 * @param customerView  
	 *           
	 */

	public checkoutButtonController(ShoppingCartView shoppingCartView, CustomerView customerView){
		this.shoppingCartView = shoppingCartView;
		this.customerView = customerView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CheckoutView checkoutView = new CheckoutView(shoppingCartView,customerView);
		shoppingCartView.hideCartView();
		
	}

}
