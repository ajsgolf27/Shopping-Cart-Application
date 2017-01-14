package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * @author Andrew Stallone 
 * @about displays the update view
 */
public class SellerViewUpdateController implements ActionListener{
	private SellerView sellerView;
	public SellerViewUpdateController(SellerView sellerView){
		this.sellerView = sellerView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		UpdateView updateView = new UpdateView(sellerView);
		
	}
}
