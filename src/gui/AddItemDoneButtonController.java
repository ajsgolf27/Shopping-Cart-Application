package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Andrew Stallone 
 * @about Done button controller on the add item screen 
 */
public class AddItemDoneButtonController implements ActionListener{

	private AddItemView addItemView;
	
	/**
	 * Constructor for the AddItemDoneButtonController Object 
	 * @param The AddItemView            
	 */
	public AddItemDoneButtonController(AddItemView addItemView) {
		this.addItemView = addItemView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		addItemView.setVisable(false);
		
	}

}
