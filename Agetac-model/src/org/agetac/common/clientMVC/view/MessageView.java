package org.agetac.common.clientMVC.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.agetac.common.clientMVC.controller.MessageController;
import org.agetac.common.clientMVC.model.MessageModel;

@SuppressWarnings("serial")
public class MessageView extends JFrame {

	private MessageController controller;
	private MessageModel model;
	
	private JPanel panel;
	private JTable table;
	private JTextField txtDate, txtMessage;
	private JButton addBut;

	public MessageView(MessageModel model) {
		
		this.model = model;
		this.controller = new MessageController(this, this.model);

		// Main Panel
		panel = new JPanel();
		panel.setLayout(new BorderLayout());

		// Messages table
		this.table = new JTable(this.model);
		
		// Messages table sort
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());   
		sorter.setSortable(0, false);
		sorter.setSortable(1, true);
		sorter.setSortable(2, false);
		sorter.setSortsOnUpdates(true);
		table.setRowSorter(sorter);
		table.getRowSorter().toggleSortOrder(1);

		// Buttons
		
		JPanel ButtonPanel = new JPanel();
		ButtonPanel.setLayout(new GridLayout());

		// Add
		addBut = new JButton("Add message");
		addBut.addActionListener(this.controller);
		ButtonPanel.add(addBut);

		
		// Fields
		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(new GridLayout());
		
		// Date field
		txtDate = new JTextField("Date");
		fieldPanel.add(txtDate);
		
		// Message field
		txtMessage = new JTextField("Message");
		fieldPanel.add(txtMessage);
		

		// Fields & Buttons Panel
		JPanel FandB = new JPanel();
		FandB.setLayout(new BorderLayout());
		FandB.add(ButtonPanel,BorderLayout.NORTH);
        FandB.add(fieldPanel,BorderLayout.SOUTH);
		
		
		// Add table, Fiels&Button panel to main panel
		panel.add(new JScrollPane(table),BorderLayout.CENTER);
		panel.add(FandB,BorderLayout.SOUTH);
        
		setContentPane(panel);
		
		
		// JFrame config
		setTitle("Messages list");
		pack();
		setVisible(true);
		
	}
	
	
	
	public String getDate(){
		return txtDate.getText();
	}
	
	public String getMessage(){
		return txtMessage.getText();
	}
	
	public void resetTxtFields(){
		txtDate.setText("Date");
		txtMessage.setText("Message");
	}
	
	public int getSelectedLine(){
		return table.getSelectedRow();
	}
		
}
