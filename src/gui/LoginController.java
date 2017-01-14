package gui;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * 
 * @author Andrew Stallone 
 * @about ActionListener for the Login button
 *  
 *  */

public class LoginController implements ActionListener{

private String usernameCustomer = "andrew";
private String passwordCustomer = "1234";
private String usernameSeller = "andrew";
private String passwordSeller = "5678";
private String username;
private String password;
private LoginView login;


/**
 * Constructor for the LoginController Object
 * 
 * @param LoginView
 * @about handles the login
 *           
 */

public LoginController(LoginView l){
	
	
	login = l;
}
	@Override
	public void actionPerformed(ActionEvent e) {
		username = login.getUsernameText();
		password = login.getPasswordText();
		if(usernameCustomer.equals(username) && passwordCustomer.equals(password)){
			CustomerView customerView = new CustomerView();
		}else if(usernameSeller.equals(username) && passwordSeller.equals(password)){
			SellerView sellerView = new SellerView();
		}else{
			login.setLabel("try Again");
		}
		
	}
	



}
