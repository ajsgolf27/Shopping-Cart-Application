package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.lang.model.element.QualifiedNameable;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;

import client.Inventory;
import client.Item;
import client.ShoppingCart;
/**
 * 
 * @author Andrew Stallone 
 * @about CustomerView class that displays the customer screen
 */
public class CustomerView {
	
	private JFrame frame = new JFrame("CustomerScreen");
	private BorderLayout borderLayout = new BorderLayout();
	private JLabel customerName = new JLabel("Hello Andrew");
	private JButton addToCart;
	private JButton checkout;
	private JPanel buttonPanel = new JPanel();
	private GridLayout buttonGrid= new GridLayout(1, 2);
	private ListSelectionListener customerListSelectionListener = new CustomerViewController(this);
	private ShoppingCart shoppingCart = new ShoppingCart();
	private Inventory productList = Inventory.getInstance();
	private ArrayList<Item> inventoryList = productList.getList();
	private JPanel description = new JPanel();
	private GridLayout descriptionGrid = new GridLayout(2,2);
	private JLabel nameLabel = new JLabel();
	private JLabel descriptionLabel = new JLabel();
	private JLabel priceLabel = new JLabel();
	private JLabel quatityLabel = new JLabel();
	private JScrollPane scrollPane = new JScrollPane();
	private ActionListener addToCartListener = new AddToCartController(this);
	private Item i;
	
	/**
	 * Constructor for the CustomerView Object
	 * 
	 * @about initializes the view 
	 *           
	 */

	public CustomerView(){
		checkout = new JButton("ShowCart");
		addToCart = new JButton("add to cart");
		frame.setLayout(borderLayout);
		customerName.setHorizontalAlignment(JLabel.CENTER);
		frame.add(customerName, BorderLayout.NORTH);
		JList<String> productListjList = populateProductList();
		scrollPane.setViewportView(productListjList);
		frame.add(scrollPane, BorderLayout.EAST);
		buttonPanel.setLayout(buttonGrid);
		buttonPanel.add(checkout);
		addToCart.addActionListener(addToCartListener);
		productListjList.addListSelectionListener(customerListSelectionListener);
		buttonPanel.add(addToCart);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		description.setLayout(descriptionGrid);
		description.setSize(150,150);
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		descriptionLabel.setHorizontalAlignment(JLabel.CENTER);
		priceLabel.setHorizontalAlignment(JLabel.CENTER);
		quatityLabel.setHorizontalAlignment(JLabel.CENTER);
		description.add(nameLabel);
		description.add(priceLabel);
		description.add(descriptionLabel);
		description.add(quatityLabel);
		frame.add(description, BorderLayout.CENTER);
		frame.pack();
		frame.setSize(400, 150);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	/**
	 * populateProductList
	 * 
	 * @about constructs the defaultListModel needed for the jlist
	 *           
	 */
	public JList<String> populateProductList(){
		
		DefaultListModel<String> model = new DefaultListModel<>();
		for(Item i: inventoryList){
			model.addElement(i.getName());
		}
		return new JList<>(model);
	}
	/**
	 * showDetails
	 * 
	 * @param index and integer value to correlates to an item in the JList
	 * @about sets the labels for the product details 
	 *           
	 */
	public void showDetails(int index){
		i = inventoryList.get(index);
		nameLabel.setText(i.getName());
		descriptionLabel.setText(i.getDescription());
		priceLabel.setText("$" +Double.toString(i.getPrice()));
		quatityLabel.setText(Integer.toString(i.getQuantity()) + " in Stock ");
		
	}
	
	/**
	 * addToCart
	 * 
	 * @about adds the selected item to the shoppingcart list 
	 *           
	 */
	public void addToCart(){
		if(i.getAmountInCart() < i.getQuantity()){
			shoppingCart.addItem(i);
			System.out.println(Integer.toString(shoppingCart.getSize()));
		}else{
			
			System.out.println("too many");
		}
	}
	
	/**
	 * getShoppingCart
	 * 
	 * @about getter for the shopping cart list 
	 * @return returns the ShoppingCart object          
	 */
	public ShoppingCart getShoppingCart(){
		return shoppingCart;
	}
	/**
	 * hideCustomerView
	 * 
	 * @about hides frame     
	 */
	public void hideCustomerView(){
		frame.setVisible(false);
	}
	
	/**
	 * showCustomerView
	 * 
	 * @about shows frame     
	 */
	public void showCustomerView(){
		frame.setVisible(true);
	}

}
