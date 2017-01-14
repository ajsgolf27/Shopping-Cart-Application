package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Andrew Stallone 
 * @about OrderConfirmationView displays the order confirmation view
 */
public class OrderConfirmationView{
	
	private JFrame frame = new JFrame();
	private JPanel orderCompletePanel = new JPanel();
	private BorderLayout borderLayout = new BorderLayout();
	private JLabel orderCompleteLabel = new JLabel("Thank you for your order, it has been submitted!");
	private JButton okButton = new JButton("Continue");
	
	/**
	 * Constructor for the OrderConfirmationView Object
	 * 
	 * @about sets up the view
	 *           
	 */
	public OrderConfirmationView(){
	okButton.addActionListener(new OrderConfirmationOKButtonController(this));
	orderCompletePanel.setLayout(borderLayout);
	frame.add(orderCompletePanel);
	orderCompletePanel.add(orderCompleteLabel, BorderLayout.NORTH);
	orderCompletePanel.add(okButton, BorderLayout.SOUTH);
	frame.pack();
	frame.setSize(375, 150);
	frame.setVisible(true);
	}
	
	/**
	 * hide
	 * 
	 * @about hides the view
	 *           
	 */
	public void hide(){
		frame.setVisible(false);
	}
	

}
