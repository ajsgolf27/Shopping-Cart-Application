package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * @author Andrew Stallone 
 * @about deletes a uitem from the list
 */
public class UpdateViewDeleteProductController implements ActionListener{
	private UpdateView updateView;
	public UpdateViewDeleteProductController(UpdateView updateView){
		this.updateView = updateView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		updateView.deleteFromInventory();
		updateView.setVisable(false);
		
	}
}
