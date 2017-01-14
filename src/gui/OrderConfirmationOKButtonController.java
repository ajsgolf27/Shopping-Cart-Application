package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
* 
* @author Andrew Stallone 
* @about ActionListener for the ok button in the OrderConfirmationView
*/
public class OrderConfirmationOKButtonController implements ActionListener{
	private OrderConfirmationView orderView;
	
	public OrderConfirmationOKButtonController(OrderConfirmationView orderView){
		this.orderView = orderView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		orderView.hide();
		
	}
	
}
