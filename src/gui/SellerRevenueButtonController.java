package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * @author Andrew Stallone 
 * @about displays the revenue view
 */
public class SellerRevenueButtonController implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		SellerRevenueView sellerRevenueView = new SellerRevenueView();	
	}

}
