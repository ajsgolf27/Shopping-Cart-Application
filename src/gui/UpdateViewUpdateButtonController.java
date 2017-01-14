package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * @author Andrew Stallone 
 * @about updates inventory
 */
public class UpdateViewUpdateButtonController implements ActionListener{

	private UpdateView updateView;
	public UpdateViewUpdateButtonController(UpdateView updateView){
		this.updateView = updateView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		updateView.updateInventory();
		updateView.setVisable(false);
		
	}
}
