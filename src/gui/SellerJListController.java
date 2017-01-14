package gui;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
* 
* @author Andrew Stallone 
* @about list selection controller on the sellerview
*/
public class SellerJListController implements ListSelectionListener{
	private SellerView sellerView;
	public SellerJListController(SellerView sellerView){
		this.sellerView = sellerView;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		JList list = (JList) e.getSource();
		int selections[] = list.getSelectedIndices();
		sellerView.updateText(selections[0]);
		
	}

}
