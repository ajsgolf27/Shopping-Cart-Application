package gui;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 * 
 * @author Andrew Stallone 
 * @about listener for the jlist
 */
public class ShoppingCartListController implements ListSelectionListener{
	private ShoppingCartView shoppingCartView;
	public ShoppingCartListController(ShoppingCartView shoppingCartView){
		this.shoppingCartView = shoppingCartView;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		JList list = (JList) e.getSource();
		int selections[] = list.getSelectedIndices();
		shoppingCartView.displayDetails(selections[0]);
	}

}
