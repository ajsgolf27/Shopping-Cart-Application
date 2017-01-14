package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * @author Andrew Stallone 
 * @about ActionListener for the quit button in the checkout view
 */
public class CheckoutQuitListener implements ActionListener{
	
	private CheckoutView checkoutView;
	private CustomerView customerView;
	private ShoppingCartView shoppingCartView;
	
	/**
	 * Constructor for the CheckoutQuitListener Object
	 * 
	 * @param CheckoutView
	 * @param ShoppingCartView
	 * @param CustomerView  
	 *           
	 */
	public CheckoutQuitListener(CheckoutView checkoutView, ShoppingCartView shoppingCartView, CustomerView customerView){
		this.checkoutView = checkoutView;
		this.customerView = customerView;
		this.shoppingCartView = shoppingCartView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		customerView.showCustomerView();
		shoppingCartView.setVisable();
		checkoutView.hideView();
		
	}
}
