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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import client.Inventory;
import client.Item;

/**
 * 
 * @author Andrew Stallone 
 * @about UpdateView class that shows the update view
 */

public class UpdateView {

	private JFrame frame = new JFrame();
	private JPanel mainPanel = new JPanel();
	private JPanel updatePanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JButton addProduct = new JButton("Update");
	private JButton deleteProduct = new JButton("Delete");
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
	private JLabel name = new JLabel();
	private JLabel price = new JLabel();
	private JLabel quantity = new JLabel();
	private JLabel description = new JLabel();
	private ActionListener add = new UpdateViewUpdateButtonController(this);
	private ActionListener delete = new UpdateViewDeleteProductController(this);
	private SellerView sellerView;
	
	/**
	 * Constructor for the UpdateView Object
	 * 
	 * @param SellerView
	 * @about sets up the view
	 *           
	 */
	public UpdateView(SellerView sellerView){
		this.sellerView = sellerView;
		frame.add(mainPanel);
		mainPanel.setLayout(borderLayout);
		c.fill = GridBagConstraints.HORIZONTAL; 
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(gridLayout);
		buttonPanel.add(deleteProduct);
		buttonPanel.add(addProduct);
		deleteProduct.addActionListener(delete);
		addProduct.addActionListener(add);
		initUpdateView();
		setTextFields();
		frame.setSize(600, 200);
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * Constructor for the UpdateView Object
	 * 
	 * @param SellerView
	 * @about sets up the view
	 *           
	 */
	public void initUpdateView(){
	
		updatePanel.setLayout(gridbag);
		
		JLabel name = new JLabel("Name: ");
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		c.ipady = 10;
		c.weightx = 0.5;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		gridbag.setConstraints(name, c);
		updatePanel.add(name);
		
		c.ipady = 10;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		gridbag.setConstraints(nameTextField, c);
		updatePanel.add(nameTextField);
		
		JLabel price = new JLabel("Price: ");
		price.setHorizontalAlignment(SwingConstants.RIGHT);
		c.ipady = 10;
		c.gridx = 2;
		c.gridy = 0;
		gridbag.setConstraints(price, c);
		updatePanel.add(price);
		
		c.ipady = 10;
		c.gridx = 3;
		c.gridy = 0;
		gridbag.setConstraints(priceTextField, c);
		updatePanel.add(priceTextField);
		
		
		JLabel quantity = new JLabel("Quantity: ");
		quantity.setHorizontalAlignment(SwingConstants.RIGHT);
		c.ipady = 10;
		c.gridx = 4;
		c.gridy = 0;
		gridbag.setConstraints(quantity, c);
		updatePanel.add(quantity);
		
		c.ipady = 10;
		c.gridx = 5;
		c.gridy = 0;
		gridbag.setConstraints(quantityTextField, c);
		updatePanel.add(quantityTextField);
		
		
		JLabel description = new JLabel("Description: ");
		description.setHorizontalAlignment(SwingConstants.RIGHT);
		description.setVerticalAlignment(SwingConstants.TOP);
		c.ipady = 40;   
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		gridbag.setConstraints(description, c);
		updatePanel.add(description);
		
		c.ipady = 40;     
		c.weightx = 0.0;
		c.gridwidth = 5;
		c.gridx = 1;
		c.gridy = 1;
		gridbag.setConstraints(descriptionTextArea, c);
		updatePanel.add(descriptionTextArea);
		
		JLabel costLabel = new JLabel("cost");
		costLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		c.ipady = 10;
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		gridbag.setConstraints(costLabel, c);
		updatePanel.add(costLabel);
		
		
		c.ipady = 10;
		c.gridx = 1;
		c.gridy = 5;
		gridbag.setConstraints(costTextField, c);
		updatePanel.add(costTextField);
		costTextField.setText("Cost");
		
		mainPanel.add(updatePanel, BorderLayout.CENTER);
	
	
}
	/**
	 * setVisable
	 * 
	 * @param if true shows the frame if false hides the frame
	 * @about show/hide the frame
	 *           
	 */
	public void setVisable(boolean visable){
		frame.setVisible(visable);
	}
	
	/**
	 * setTextFields
	 * 
	 * @about sets the textfields with the proper information
	 *           
	 */
	public void setTextFields(){
		int index = sellerView.getIndex();
		Item i = itemList.get(index);
		nameTextField.setText(i.getName());
		descriptionTextArea.setText(i.getDescription());
		quantityTextField.setText(Integer.toString(i.getQuantity()));
		priceTextField.setText(Double.toString(i.getPrice()));
		costTextField.setText(Double.toString(i.getCost()));
	}
	
	/**
	 * updateInventory
	 * 
	 * @about updates the inventory
	 *           
	 */
	public void updateInventory(){
		int index = sellerView.getIndex();
		Item i = itemList.get(index);
		i.setName(nameTextField.getText());
		i.setDecscription(descriptionTextArea.getText());
		i.setQuantity(Integer.parseInt(quantityTextField.getText()));
		i.setPrice(Double.parseDouble(priceTextField.getText()));
		i.setCost(Double.parseDouble(costTextField.getText()));
		
		sellerView.updateText(index);
		

	}
	
	/**
	 * deleteFromInventory
	 * 
	 * @about deletes from the inventory
	 *           
	 */
	public void deleteFromInventory(){
		int index = sellerView.getIndex();
		Item i = itemList.remove(index);
		sellerView.updateInventory();
		
	}
	
	
}

