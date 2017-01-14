package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * @author Andrew Stallone 
 * @about displays the additem view
 */
public class SellerViewAddProductsController implements ActionListener{
	private SellerView sellerView;
	public SellerViewAddProductsController(SellerView sellerView){
		this.sellerView = sellerView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AddItemView itemView = new AddItemView(sellerView);
		
	}

}
