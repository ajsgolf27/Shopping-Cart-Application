package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

import client.Item;
import client.ShoppingCart;
/**
 * 
 * @author Andrew Stallone 
 * @about displays the shoppingCart view
 */
public class ShoppingCartView {

	private JFrame frame = new JFrame("shoppingCartView");
	private ShoppingCart shoppingCart;
	private BorderLayout borderLayout = new BorderLayout();
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel editInfo = new JPanel();
	private GridLayout grid = new GridLayout(6,2);
	private LinkedList<Item> shoppingCartLinkedList;
	private FlowLayout flowLayout =  new FlowLayout();
	private JPanel flowPanel = new JPanel();
	private JList<String> shoppingCartList;
	private JLabel productName = new JLabel();
	private JLabel productPrice = new JLabel();
	private JLabel numberOfProducts = new JLabel("quantity ");
	private JButton deleteFromShoppingCart;
	private JButton update;
	private JTextField updateQuantity = new JTextField();
	private JButton checkOutButton;
	private CustomerView customerView;
	private ListSelectionListener listSelector = new ShoppingCartListController(this);
	private ActionListener deleteButton = new ShoppingCartViewController(this);
	private ActionListener updateButtonListener = new UpdateButtonController(this);
	private JLabel subtotal;
	private int SelectedIndex = 0;
	
	
	/**
	 * Constructor for the ShoppingCartView Object
	 * 
	 * @param ShoppingCart
	 * @param CustomerView
	 * @about sets up the view
	 *           
	 */

	public ShoppingCartView(ShoppingCart shoppingCart, CustomerView customerView){
		this.customerView = customerView;
		ActionListener checkoutButtonListener = new checkoutButtonController(this, customerView);
		deleteFromShoppingCart = new JButton("Delete");
		update = new JButton("Update");
		checkOutButton = new JButton("Checkout");
		frame.setLayout(borderLayout);
		flowPanel.setLayout(flowLayout);
		flowPanel.add(numberOfProducts);
		flowPanel.add(updateQuantity);
		editInfo.setLayout(grid);
		editInfo.add(productName);
		editInfo.add(productPrice);
		editInfo.add(flowPanel);
		deleteFromShoppingCart.addActionListener(deleteButton);
		update.addActionListener(updateButtonListener);
		editInfo.add(update);
		editInfo.add(deleteFromShoppingCart);
		editInfo.add(checkOutButton);
		checkOutButton.addActionListener(checkoutButtonListener);
		productName.setHorizontalAlignment(JLabel.CENTER);
		productPrice.setHorizontalAlignment(JLabel.CENTER);
		this.shoppingCart = shoppingCart;
		shoppingCartLinkedList = shoppingCart.getList();
		shoppingCartList = populateProductList();
		shoppingCartList.addListSelectionListener(listSelector);
		scrollPane.setViewportView(shoppingCartList);
		frame.add(scrollPane, BorderLayout.EAST);
		frame.add(editInfo, BorderLayout.CENTER);
		productName.setText(shoppingCartLinkedList.get(0).getName());
		productPrice.setText(Double.toString(shoppingCartLinkedList.get(0).getPrice()));
		updateQuantity.setText(Integer.toString(shoppingCartLinkedList.get(0).getAmountInCart()));
		subtotal = new JLabel("Subtotal $" +Double.toString(getSubTotal()));
		frame.add(subtotal, BorderLayout.SOUTH);
		frame.pack();
		frame.setSize(400, 300);
		frame.setVisible(true);
	}
	
	
public JList<String> populateProductList(){
	
		DefaultListModel<String> model = new DefaultListModel<>();
		model.clear();
		
		for(Item i: shoppingCartLinkedList){
			model.addElement(i.getName());
		}
		return new JList<>(model);
	}

/**
 * repaint
 * 
 * @param ShoppingCart
 * @about refreshes the view
 *           
 */

	public void repaint(ShoppingCart shoppingCart){
		frame.setLayout(borderLayout);
		shoppingCartLinkedList = shoppingCart.getList();
		shoppingCartList = populateProductList();
		shoppingCartList.addListSelectionListener(listSelector);
		scrollPane.setViewportView(shoppingCartList);
		frame.add(scrollPane, BorderLayout.EAST);
		editInfo.setLayout(grid);
		flowPanel.setLayout(flowLayout);
		flowPanel.add(numberOfProducts);
		flowPanel.add(updateQuantity);
		editInfo.add(productName);
		editInfo.add(productPrice);
		editInfo.add(flowPanel);
		editInfo.add(update);
		editInfo.add(deleteFromShoppingCart);
		editInfo.add(checkOutButton);
		frame.add(editInfo, BorderLayout.CENTER);
		frame.setLocation(frame.getLocation().x, frame.getLocation().y);
		frame.setSize(frame.getWidth(),frame.getHeight());
		subtotal.setText("Subtotal $" +Double.toString(shoppingCart.getSubtotal()));
		frame.add(subtotal, BorderLayout.SOUTH);
		if(shoppingCartLinkedList.size() == 0){
			frame.setVisible(false);
			frame.dispose();
		}else{
		frame.validate();
		frame.repaint();
		}
		
	}
	
	/**
	 * displayDetails
	 * 
	 * @param int the index of the list
	 * @about displays the details 
	 *           
	 */
	public void displayDetails(int index){
		SelectedIndex = index;
		Item i = shoppingCartLinkedList.get(index);
		productName.setHorizontalAlignment(JLabel.CENTER);
		productPrice.setHorizontalAlignment(JLabel.CENTER);
		productName.setText(i.getName());
		updateQuantity.setText(Integer.toString(i.getAmountInCart()));
		productPrice.setText("$" +Double.toString(i.getPrice() * i.getAmountInCart()));
		subtotal.setText("Subtotal $" +Double.toString(getSubTotal()));
		frame.add(subtotal, BorderLayout.SOUTH);
	}
	
	/**
	 * deleteItem
	 * 
	 * @about deletes item from the list
	 *           
	 */
	public void deleteItem(){
		if(shoppingCartLinkedList.size() > 0){
			Item i = shoppingCartLinkedList.get(SelectedIndex);
			i.setAmountInCart(0);
			shoppingCartLinkedList.remove(SelectedIndex);
			repaint(shoppingCart);
			productName.setText("          ");
			productPrice.setText("         ");
			
		}
		
	}
	
	/**
	 * getSubTotal
	 * 
	 * @about computes the subtotal
	 * @return the subtotal
	 */
	public double getSubTotal(){
		double result = 0;
		for(Item i: shoppingCartLinkedList){
			result += i.getPrice() * i.getAmountInCart();
		}
		return result;
	}
	
	/**
	 * update
	 * 
	 * @about updates item from the list
	 *           
	 */
	public void update(){
		Item i = shoppingCartLinkedList.get(SelectedIndex);
		if(i.getQuantity() >= Integer.parseInt(updateQuantity.getText())){
		i.setAmountInCart(Integer.parseInt(updateQuantity.getText()));
		productPrice.setText("$" +Double.toString(i.getPrice() * i.getAmountInCart()));
		subtotal.setText("Subtotal $" +Double.toString(getSubTotal()));
		}else{
			updateQuantity.setText(Integer.toString(i.getQuantity()));
		}
		
		
	}
	
	/**
	 * getShoppingCart
	 * 
	 * @about getter for the shopping cart list
	 * @return the shopping cart list        
	 */
	public LinkedList<Item> getShoppingCart(){
		return shoppingCartLinkedList;
	}
	
	/**
	 * hideCartView
	 * 
	 * @about hides the shopping cart
	 *     
	 */
	public void hideCartView(){
		frame.setVisible(false);
	}
	
	/**
	 * setVisable
	 * 
	 * @about shows the shopping cart
	 *    
	 */
	public void setVisable(){
		frame.setVisible(true);
	}
	
	/**
	 * hideCustomerView
	 * 
	 * @about hides the customer view
	 * 
	 */
	public void hideCustomerView(){
		customerView.hideCustomerView();
	}
	
	/**
	 * showCustomerView
	 * 
	 * @about shows the customer view
	 *    
	 */
	public void showCustomerView(){
		customerView.showCustomerView();
	}
}
