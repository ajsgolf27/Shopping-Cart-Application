package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionListener;

import client.Inventory;
import client.Item;
/**
 * 
 * @author Andrew Stallone 
 * @about SellerView class to display the seller view
 */
public class SellerView {
	
	private JFrame frame = new JFrame();
	private JPanel mainPanel = new JPanel();
	private JPanel updatePanel = new JPanel();
	private JPanel editPanel = new JPanel();
	private JPanel productPanel = new JPanel();
	private JPanel itemPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JScrollPane scrollPane = new JScrollPane();
	private JLabel sellersNameLabel = new JLabel("Hello Andrew");
	private JButton showReport = new JButton("Revenue Report");
	private JButton editProducts = new JButton("Edit");
	private JButton addProduct = new JButton("Add New Item");
	private JTextField nameTextField = new JTextField();
	private JTextField quantityTextField = new JTextField();
	private JTextField priceTextField = new JTextField();
	private JTextArea descriptionTextArea = new JTextArea();
	private JTextArea costTextField = new JTextArea();
	private JList<String> productList;
	private BorderLayout borderLayout = new BorderLayout();
	private GridLayout gridLayout = new GridLayout(1,3);
	private GridBagLayout gridbag = new GridBagLayout();
	private GridBagConstraints c = new GridBagConstraints();
	private ActionListener addItemsListener = new SellerViewAddProductsController(this);
	private ActionListener update = new SellerViewUpdateController(this);
	private ActionListener revenue = new SellerRevenueButtonController();
	private int index = 0;
	private ArrayList<Item> itemList = new ArrayList<Item>();
	private Inventory inventory = Inventory.getInstance();
	private ListSelectionListener listSelection;
	private JLabel name = new JLabel();
	private JLabel price = new JLabel();
	private JLabel quantity = new JLabel();
	private JLabel description = new JLabel();
	private JLabel cost = new JLabel();
	
	
	
	
	/**
	 * Constructor for the SellerView Object
	 * 
	 * @about sets up the view
	 *           
	 */
	public SellerView(){
		listSelection = new SellerJListController(this);
		frame.add(mainPanel);
		mainPanel.setLayout(borderLayout);
		c.fill = GridBagConstraints.HORIZONTAL; 
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(gridLayout);
		buttonPanel.add(addProduct);
		buttonPanel.add(editProducts);
		buttonPanel.add(showReport);
		editProducts.addActionListener(update);
		addProduct.addActionListener(addItemsListener);
		showReport.addActionListener(revenue);
		itemList = inventory.getList();
		productList = populateProductList();
		productList.addListSelectionListener(listSelection);
		scrollPane.setViewportView(productList);
		itemPanel.add(scrollPane);
		mainPanel.add(itemPanel, BorderLayout.EAST);
		mainPanel.add(sellersNameLabel, BorderLayout.NORTH);
		if(itemList.size() != 0){
		initlabelView(0);
		}else{
			initEmptyLabelView();
		}
		frame.setSize(300, 300);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public void updateInventory(){
		itemList = inventory.getList();
		productList = populateProductList();
		productList.addListSelectionListener(listSelection);
		scrollPane.setViewportView(productList);
		itemPanel.add(scrollPane);
		mainPanel.add(itemPanel, BorderLayout.EAST);
		frame.validate();
		frame.repaint();
	}
	
	
	
	public JList<String> populateProductList(){
		
		DefaultListModel<String> model = new DefaultListModel<>();
		model.clear();
		
		for(Item i: itemList){
			model.addElement(i.getName());
		}
		return new JList<>(model);
	}
	
	/**
	 * initEmptyLabelView
	 * 
	 * @about sets up the gridbag constraints for the view
	 *           
	 */
	public void initEmptyLabelView(){
		productPanel.setLayout(gridbag);
		
		c.ipady = 10;
		c.weightx = 0.5;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		gridbag.setConstraints(name, c);
		productPanel.add(name);
		
		c.ipady = 10;
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		gridbag.setConstraints(price, c);
		productPanel.add(price);
		
		
		c.ipady = 10;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		gridbag.setConstraints(quantity, c);
		productPanel.add(quantity);
		
		
		c.ipady = 40;   
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 1;
		gridbag.setConstraints(description, c);
		productPanel.add(description);
		
		c.ipady = 10;
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 1;
		gridbag.setConstraints(cost, c);
		productPanel.add(cost);
		
		
		mainPanel.add(productPanel, BorderLayout.CENTER);
		frame.validate();
		frame.repaint();
		
	}
	
	/**
	 * initEmptyLabelView
	 * 
	 * @param int index of item to be displayed
	 * @about sets up the gridbag constraints for the view and sets labels
	 *           
	 */
	public void initlabelView(int index){
		
		Item i = itemList.get(index);
		name.setText(i.getName());
		price.setText(Double.toString(i.getPrice()));
		cost.setText("product cost $" + Double.toString(i.getCost()));
		quantity.setText(Integer.toString(i.getQuantity())+ " in stock");
		description.setText(i.getDescription());
		price.setHorizontalAlignment(SwingConstants.RIGHT);
		description.setHorizontalAlignment(SwingConstants.RIGHT);
	
		productPanel.setLayout(gridbag);
		
		c.ipady = 10;
		c.weightx = 0.5;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		gridbag.setConstraints(name, c);
		productPanel.add(name);
		
		c.ipady = 10;
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		gridbag.setConstraints(price, c);
		productPanel.add(price);
		
		
		c.ipady = 10;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		gridbag.setConstraints(quantity, c);
		productPanel.add(quantity);
		
		
		c.ipady = 40;   
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 1;
		gridbag.setConstraints(description, c);
		productPanel.add(description);
		
		c.ipady = 10;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		gridbag.setConstraints(cost, c);
		productPanel.add(cost);
		
		
		mainPanel.add(productPanel, BorderLayout.CENTER);
		frame.validate();
		frame.repaint();
		
	}
	
	/**
	 * updateText
	 * 
	 * @return int the index of the list
	 * @about updates the text in the view
	 *           
	 */
	public void updateText(int index){
		this.index = index;
		Item i = itemList.get(index);
		name.setText(i.getName());
		price.setText(Double.toString(i.getPrice()));
		quantity.setText(Integer.toString(i.getQuantity())+ " in stock");
		description.setText(i.getDescription());
		cost.setText("Product cost $" + Double.toString(i.getCost()));
	}
	
	/**
	 * getIndex
	 * 
	 * @return int the index of the list
	 * @about returns the index of the list
	 *           
	 */
	public int getIndex(){
		return index;
	}
	
	
	
	
}
