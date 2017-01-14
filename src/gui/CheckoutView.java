package gui;

import java.awt.BorderLayout;
import java.awt.Desktop.Action;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import client.Inventory;
import client.Item;
import client.Order;
import client.OrderList;
import client.ShoppingCart;
/**
 * 
 * @author Andrew Stallone 
 * @about CheckoutView sets up the view for the checkout view
 */
public class CheckoutView {
	private Inventory productList = Inventory.getInstance();
	private ShoppingCart shoppingCart;
	private ShoppingCartView shoppingCartView;
	private LinkedList<Item> shoppingCartLinkedList = new LinkedList<Item>();
	private JFrame frame = new JFrame("CheckoutView");
	private JPanel checkout = new JPanel();
	private JScrollPane scrollPane = new JScrollPane();
	private BorderLayout borderLayout = new BorderLayout();
	private GridLayout gridLayout = new GridLayout(5,1);
	private JPanel totals = new JPanel();
	private JLabel subtotal = new JLabel("Subtotal");
	private JLabel tax = new JLabel("Tax");
	private JLabel total = new JLabel("Total");
	private JButton pay;
	private JButton Cancel;
	private JList<String> itemJList;
	private CustomerView customerView;
	private ActionListener payListener = new CheckoutViewController(this);

	
	/**
	 * Constructor for the CheckoutView Object
	 * 
	 * @param ShoppingCartView
	 * @param CustomerView
	 * @about does initial setup for the view
	 *           
	 */
	public CheckoutView(ShoppingCartView shoppingCarView, CustomerView customerView){
		this.shoppingCartView = shoppingCarView;
		this.customerView = customerView;
		ActionListener cancelListener = new CheckoutQuitListener(this, shoppingCartView, customerView);
		Cancel = new JButton("Cancel");
		Cancel.addActionListener(cancelListener);
		shoppingCartLinkedList = shoppingCartView.getShoppingCart();
		init();
		
	}
	/**
	 * init
	 * 
	 * @about does initial setup for the view
	 *           
	 */
	public void init(){
		pay = new JButton("Pay");
		pay.addActionListener(payListener);
		shoppingCartView.hideCustomerView();
		itemJList = populateProductList();
		scrollPane.setViewportView(itemJList);
		totals.setLayout(gridLayout);
		totals.add(subtotal);
		totals.add(tax);
		totals.add(total);
		totals.add(pay);
		totals.add(Cancel);
		checkout.setLayout(borderLayout);
		checkout.add(scrollPane, BorderLayout.CENTER);
		checkout.add(totals, BorderLayout.SOUTH);
		frame.add(checkout);
		showDetails();
		frame.pack();
		frame.setSize(200, 500);
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
		for(Item i: shoppingCartLinkedList){
			model.addElement(i.getName()+ " X " + Integer.toString(i.getAmountInCart()) + " = " + 
		Double.toString(i.getPrice() * i.getAmountInCart()));
		}
		return new JList<>(model);
	}
/**
 * showDetails
 * 
 * @about sets the text for the labels showing subtotal,tax and total
 *           
 */
public void showDetails(){
	double subtotal = 0;
	double total;
	final Double TAX = 0.06;
	for(Item i: shoppingCartLinkedList){
		subtotal += i.getPrice() * i.getAmountInCart();
	}
	total = (subtotal * TAX) + subtotal;
	this.subtotal.setText("Subtotal $" + subtotal);
	this.tax.setText("Tax 6%");
	this.total.setText("Total $" + total);
	}

/**
 * hideView
 * 
 * @about sets setVisable to false 
 *           
 */
public void hideView(){
	frame.setVisible(false);
	}

/**
 * updateInventory
 * 
 * @about updates changes for the item in the inventory list and adds the items to an order
 *           
 */
public void updateInventory(){
	Order order = new Order();
	ArrayList<Item> inventoryList = productList.getList();
	int index = 0;
	for(Item i:shoppingCartLinkedList){
		index = inventoryList.indexOf(i);
		i.setQuantity(i.getQuantity() - inventoryList.get(index).getAmountInCart());
		i.setOrderAmount(i.getAmountInCart());
		i.setAmountInCart(0);
		order.addItem(i);
	}
	OrderList orderList = OrderList.getInstance();
	orderList.add(order);
	}

}
