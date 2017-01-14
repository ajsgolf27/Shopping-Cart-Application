package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.Inventory;
/**
 * 
 * @author Andrew Stallone 
 * @about Student class that sorts by date or name
 */
public class CheckoutViewController implements ActionListener{
private CheckoutView checkoutView;
/**
 * Constructor for the CheckoutViewController Object
 * 
 * @param CheckoutView
 *           
 */
	public CheckoutViewController(CheckoutView checkoutView){
		this.checkoutView = checkoutView;
	}
		@Override
	public void actionPerformed(ActionEvent e) {
			checkoutView.updateInventory();		
			OrderConfirmationView orderConfirmationView = new OrderConfirmationView();
			checkoutView.hideView();
		
	}

}
