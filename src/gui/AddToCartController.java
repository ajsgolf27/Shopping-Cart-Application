package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.ShoppingCart;
/**
 * 
 * @author Andrew Stallone 
 * @about ActionListener for the add to cart button in the CustomerView
 */
public class AddToCartController implements ActionListener{
private CustomerView customerView;
private ShoppingCart shoppingCart;
private ShoppingCartView shoppingCartView;

/**
 * Constructor for the AddToCartController Object
 * 
 * @param CustomerView
 
 *           
 */
	public AddToCartController(CustomerView c){
		customerView = c;
	}

	
		@Override
		public void actionPerformed(ActionEvent e) {
			shoppingCart = customerView.getShoppingCart();
			if(shoppingCart.getSize() == 0){
				customerView.addToCart();
				shoppingCartView = new ShoppingCartView(shoppingCart,customerView);
				
				
			}else{
				customerView.addToCart();
				shoppingCartView.repaint(shoppingCart);
				shoppingCartView.setVisable();
			}
			
			
		
		
	}
}
