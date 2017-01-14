package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * @author Andrew Stallone 
 * @about deletes item from the shopping cart
 */
public class ShoppingCartViewController implements ActionListener{
private ShoppingCartView shoppingCartView;
	public ShoppingCartViewController(ShoppingCartView shoppingCartView){
		this.shoppingCartView = shoppingCartView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		shoppingCartView.deleteItem();
		
		
	}

}
