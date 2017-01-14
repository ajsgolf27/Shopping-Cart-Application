package gui;


import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 * 
 * @author Andrew Stallone 
 * @about ListSelectionListener for the CustomerViewController class notifies when the user clicks
 */


public class CustomerViewController implements  ListSelectionListener{
	private CustomerView customerView;
	/**
	 * Constructor for the CustomerViewController Object
	 * 
	 * @param CustomerView
	 */
	public CustomerViewController(CustomerView c) {
		
		customerView = c;
	}


	@Override
	public void valueChanged(ListSelectionEvent e) {
		JList list = (JList) e.getSource();
		int selections[] = list.getSelectedIndices();
		customerView.showDetails((selections[0]));
		
	}
	
	
	
}
