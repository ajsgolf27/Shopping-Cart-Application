package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import client.Order;
import client.OrderList;
/**
 * 
 * @author Andrew Stallone 
 * @about SellerRevenueView class that displays the revenue
 */

public class SellerRevenueView {
	private ArrayList<Order> listOfOrders = new ArrayList<Order>();
	private JFrame frame = new JFrame();
	private JPanel mainPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JPanel revenuePanel = new JPanel();
	private JLabel totalRevenue = new JLabel();
	private JLabel totalCost = new JLabel();
	private JLabel totalProfit = new JLabel();
	private JButton done = new JButton("done");
	private BorderLayout borderLayout = new BorderLayout();
	private GridBagLayout gridbag = new GridBagLayout();
	private GridBagConstraints c = new GridBagConstraints();
	private ActionListener doneListener = new RevenueViewController(this);
	
	/**
	 * Constructor for the SellerRevenueView Object
	 * 
	 * @about sets up the view
	 *           
	 */
	public SellerRevenueView(){
		OrderList orderList = OrderList.getInstance();
		listOfOrders = orderList.getOrderList();
		NumberFormat formatter = new DecimalFormat("00.00");  
		String s = formatter.format(orderList.getTotalRevenue());
		totalRevenue.setText("Total Revenue $" + s);
		s = formatter.format(orderList.getTotalCost());
		totalCost.setText("Total Cost $" + s);
		s = formatter.format(orderList.getTotalRevenue() - orderList.getTotalCost());
		totalProfit.setText("Total Profit $" + s);
		frame.add(mainPanel);
		mainPanel.setLayout(borderLayout);
		revenuePanel.setLayout(gridbag);
		
		c.ipady = 10;
		c.weightx = 0.5;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		gridbag.setConstraints(totalRevenue, c);
		revenuePanel.add(totalRevenue);
		
		c.gridy = 1;
		gridbag.setConstraints(totalCost, c);
		revenuePanel.add(totalCost);
		
		c.gridy = 2;
		gridbag.setConstraints(totalProfit, c);
		revenuePanel.add(totalProfit);
		
		mainPanel.add(revenuePanel, BorderLayout.CENTER);
		buttonPanel.add(done);
		done.addActionListener(doneListener);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		frame.setSize(500, 500);
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * close
	 * 
	 * @about disposes the view
	 *           
	 */
	public void close(){
		frame.dispose();
	}
}
