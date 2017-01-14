package client;
/**
 * 
 * @author Andrew Stallone 
 * Customer class to create a Customer
 */
public class Customer extends User{
	
public Customer(String name, String username, String password) {
		super(name, username, password);
		// TODO Auto-generated constructor stub
	}

@Override
	public void setId(String id) {
		// set to customer
		super.setId(id);
	}


}
