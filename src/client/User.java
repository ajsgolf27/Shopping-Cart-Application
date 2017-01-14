package client;
/**
 * 
 * @author Andrew Stallone 
 * @about User class to create a user
 */
public class User {
	private String name = "";
	private String identifier = "";  //seller or customer to load the correct screen
	private String username = "";
	private String password = "";
	
	/**
	 * Constructor for the User Object
	 * 
	 * @param name of user
	 * @param username
	 * @param password
	 *           
	 */

	public User (String name, String username, String password){
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * resetPassword
	 * 
	 * @param new password
	 * @about resets password
	 *           
	 */

	public void resetPassword(String password){
		this.password = password;
	}
	
	/**
	 *getPassword
	 * 
	 * @about returns current password
	 *           
	 */
	public String getPassword(){return password;}
	
	/**
	 * getName
	 * 
	 * @about returns current name
	 *           
	 */
	public String getName(){return name;};
	
	/**
	 * getUserName
	 * 
	 * @about returns username
	 *           
	 */
	public String getUserName(){return username;};
	
	/**
	 * SetId
	 * 
	 * @about sets ID
	 * @return 
	 *           
	 */
	public void setId(String id){
		this.identifier = id;
		
	}
	
	/**
	 * getId
	 * 
	 * @about gets id
	 * @return id
	 *           
	 */
	public String getId(){
		return identifier;
	}
	
	
	

}
