package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
 * @about View to add an item 
 */
public class AddItemView {
	
	private JFrame frame = new JFrame();
	private JPanel mainPanel = new JPanel();
	private JPanel editPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JButton doneButton = new JButton("Done");
	private JButton addProduct = new JButton("Add New Item");
	private JTextField nameTextField = new JTextField();
	private JTextField quantityTextField = new JTextField();
	private JTextField priceTextField = new JTextField();
	private JTextArea descriptionTextArea = new JTextArea();
	private JTextField costTextField = new JTextField();
	private BorderLayout borderLayout = new BorderLayout();
	private GridLayout gridLayout = new GridLayout(1,2);
	private GridBagLayout gridbag = new GridBagLayout();
	private GridBagConstraints c = new GridBagConstraints();
	private Inventory inventory = Inventory.getInstance();
	private ArrayList<Item> itemList = inventory.getList();
	private ActionListener done = new AddItemDoneButtonController(this);
	private SellerView sellerview;

	/**
	 * Constructor for the AddItemView Object
	 * 
	 * @param SellerView
	 * @about setup the view
	 *           
	 */
	public AddItemView(SellerView sellerView){
		this.sellerview = sellerView;
		ActionListener add = new AddItemViewController(this,sellerView);
		frame.add(mainPanel);
		mainPanel.setLayout(borderLayout);
		c.fill = GridBagConstraints.HORIZONTAL; 
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(gridLayout);
		buttonPanel.add(addProduct);
		buttonPanel.add(doneButton);
		addProduct.addActionListener(add);
		doneButton.addActionListener(done);
		initAddNewItem();
		frame.setSize(600, 200);
		frame.pack();
		frame.setVisible(true);
	}
	/**
	 * initAddNewItem
	 * 
	 * 
	 * @about sets up the editpanel with a gridbag layout creates all contraints and labels.
	 *           
	 */
	public void initAddNewItem(){
		
			editPanel.setLayout(gridbag);
			
			JLabel name = new JLabel("Name: ");
			name.setHorizontalAlignment(SwingConstants.RIGHT);
			c.ipady = 10;
			c.weightx = 0.5;
			c.gridwidth = 1;
			c.gridx = 0;
			c.gridy = 0;
			gridbag.setConstraints(name, c);
			editPanel.add(name);
			
			c.ipady = 10;
			c.weightx = 0.5;
			c.gridx = 1;
			c.gridy = 0;
			gridbag.setConstraints(nameTextField, c);
			editPanel.add(nameTextField);
			nameTextField.setText("name");
			
			JLabel price = new JLabel("Price: ");
			price.setHorizontalAlignment(SwingConstants.RIGHT);
			c.ipady = 10;
			c.gridx = 2;
			c.gridy = 0;
			gridbag.setConstraints(price, c);
			editPanel.add(price);
			
			c.ipady = 10;
			c.gridx = 3;
			c.gridy = 0;
			gridbag.setConstraints(priceTextField, c);
			editPanel.add(priceTextField);
			priceTextField.setText("price");
			
			JLabel quantity = new JLabel("Quantity: ");
			quantity.setHorizontalAlignment(SwingConstants.RIGHT);
			c.ipady = 10;
			c.gridx = 4;
			c.gridy = 0;
			gridbag.setConstraints(quantity, c);
			editPanel.add(quantity);
			
			c.ipady = 10;
			c.gridx = 5;
			c.gridy = 0;
			gridbag.setConstraints(quantityTextField, c);
			editPanel.add(quantityTextField);
			quantityTextField.setText("quantity");
			
			JLabel description = new JLabel("Description: ");
			description.setHorizontalAlignment(SwingConstants.RIGHT);
			description.setVerticalAlignment(SwingConstants.TOP);
			c.ipady = 40;   
			c.weightx = 0.0;
			c.gridwidth = 1;
			c.gridx = 0;
			c.gridy = 1;
			gridbag.setConstraints(description, c);
			editPanel.add(description);
			
			c.ipady = 40;     
			c.weightx = 0.0;
			c.gridwidth = 5;
			c.gridx = 1;
			c.gridy = 1;
			gridbag.setConstraints(descriptionTextArea, c);
			editPanel.add(descriptionTextArea);
			
			JLabel costLabel = new JLabel("cost");
			costLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			c.ipady = 10;
			c.gridx = 0;
			c.gridy = 5;
			c.gridwidth = 1;
			gridbag.setConstraints(costLabel, c);
			editPanel.add(costLabel);
			
			
			c.ipady = 10;
			c.gridx = 1;
			c.gridy = 5;
			gridbag.setConstraints(costTextField, c);
			editPanel.add(costTextField);
			costTextField.setText("Cost");
			
			
			mainPanel.add(editPanel, BorderLayout.CENTER);
			
		}
	/**
	 * setVisable
	 * 
	 * @param boolean true to see the view false to hide.
	 * @about sets the frame visibilty
	 *           
	 */
	public void setVisable(boolean visable){
		frame.setVisible(visable);
	}
	/**
	 * addToInventory
	 * @about adds an item to the singleton class Inventory and displays the labels
	 *           
	 */
	public void addToInventory(){
		Item i = new Item(nameTextField.getText(), descriptionTextArea.getText(), Integer.parseInt(quantityTextField.getText()),
				Double.parseDouble(priceTextField.getText()), Double.parseDouble(costTextField.getText()));
		itemList.add(i);
		nameTextField.setText("");
		descriptionTextArea.setText("");
		quantityTextField.setText("");
		priceTextField.setText("");

	}
	

	
}
