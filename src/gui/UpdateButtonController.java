package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * @author Andrew Stallone 
 * @about updates items in the shopping cart
 */
public class UpdateButtonController implements ActionListener{
	
private ShoppingCartView shoppingCartView;

	public UpdateButtonController(ShoppingCartView shoppingCartView){
		this.shoppingCartView = shoppingCartView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		shoppingCartView.update();
		
	}

}
