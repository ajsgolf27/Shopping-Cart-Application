package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
* 
* @author Andrew Stallone 
* @about ActionListener for the add button in the addItemView
*/

public class AddItemViewController implements ActionListener{

	private AddItemView addItemView;
	private SellerView sellerView;
	/**
	 * Constructor for the AddItemViewController Object
	 * 
	 * @param AddItemView
	 * @param SellerView 
	 *           
	 */
	public AddItemViewController(AddItemView addItemView, SellerView sellerView) {
		this.addItemView = addItemView;
		this.sellerView = sellerView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		addItemView.addToInventory();
		sellerView.updateInventory();
		
		
	}
}
