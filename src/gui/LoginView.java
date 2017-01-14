package gui;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * 
 * @author Andrew Stallone 
 * @about LoginView class that displays the login frame
 */
public class LoginView {
	
	
	private JFrame frame = new JFrame("Login");
	private JTextField usernameTextField = new JTextField();
	private JTextField passwordTextField = new JTextField();
	private JLabel label = new JLabel();
	private JButton login = new JButton("Login");
	
	/**
	 * Constructor for the LoginView Object
	 * 
	 * @about sets up the view 
	 *           
	 */

	public LoginView(){
		frame.setLayout(new GridLayout(3, 2));
		frame.add(new Label("Username:"));
		frame.add(usernameTextField);
		frame.add(new Label("Password:"));
		frame.add(passwordTextField);
		frame.add(login);
		frame.add(label);
		frame.pack();
		frame.setSize(400, 100);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		ActionListener loginActionListener = new LoginController(this);
		login.addActionListener(loginActionListener);
	}
	
	/**
	 * setLabel
	 * 
	 * @param the text to be displayed
	 * @about sets the label with the given text.
	 *           
	 */
	public void setLabel(String label){
		this.label.setText(label);
	}
	
	/**
	 * getUsernameText
	 * 
	 * @return String
	 * @about returns the text from the usernameTextField
	 *           
	 */
	public String getUsernameText(){
		return usernameTextField.getText();
	}
	
	/**
	 * getPasswordText
	 * 
	 * @return String
	 * @about returns the text from the passwordTextField
	 *           
	 */
	public String getPasswordText(){
		return passwordTextField.getText();
	}
	
	
}
