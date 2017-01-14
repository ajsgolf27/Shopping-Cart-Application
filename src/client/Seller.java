package client;

/**
 * 
 * @author Andrew Stallone
 * @about Seller class to create a Seller
 */
public class Seller extends User {

	public Seller(String name, String username, String password) {
		super(name, username, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setId(String id) {
		// set to seller
		super.setId(id);
	}

}
