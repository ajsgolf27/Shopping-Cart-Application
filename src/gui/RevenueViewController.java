package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
* 
* @author Andrew Stallone 
* @about Done button controller on the revenue screen 
*/
public class RevenueViewController implements ActionListener{
	private SellerRevenueView sellerRevenueView;
	
	public RevenueViewController(SellerRevenueView sellerRevenueView) {
		this.sellerRevenueView = sellerRevenueView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sellerRevenueView.close();
		
	}

}
