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

import org.agetac.common.clientMVC.controller.SourceController;
import org.agetac.common.clientMVC.model.SourceModel;
import org.agetac.common.dto.SourceDTO;
import org.agetac.common.dto.SourceDTO.SourceType;

public class SourceView extends JFrame{

	private SourceController controller;
	private SourceModel model;
	
	private JPanel panel;
	private JTable table;
	private JTextField txtId, txtLatitude, txtLongitude, txtType;
	private JButton addBut, delBut;

	public SourceView(SourceModel model) {
		
		this.model = model;
		this.controller = new SourceController(this, this.model);

		// Conteneur principal
		panel = new JPanel();
		panel.setLayout(new BorderLayout());

		// Tableau des messages
		this.table = new JTable(this.model);
		// Tri tableau des messages
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());   
		sorter.setSortable(0, true);
		sorter.setSortable(1, false);
		sorter.setSortsOnUpdates(true);
		table.setRowSorter(sorter);
		table.getRowSorter().toggleSortOrder(0);

		// Les boutons
		
		JPanel panelButton = new JPanel();
		panelButton.setLayout(new GridLayout());

		// Ajouter
		addBut = new JButton("Ajouter une source");
		addBut.addActionListener(this.controller);
		panelButton.add(addBut);

		// Supprimer
		delBut = new JButton("Supprimer une source");
		delBut.addActionListener(this.controller);
		panelButton.add(delBut);
		
		//Champs
		JPanel panelChamps = new JPanel();
		panelChamps.setLayout(new GridLayout());
		
		// Champ ID
		txtId = new JTextField("ID");
		panelChamps.add(txtId);
		
		// Champ Lat
		txtLatitude = new JTextField("Latitude");
		panelChamps.add(txtLatitude);
		
		// Champ Long
		txtLongitude = new JTextField("Longitude");
		panelChamps.add(txtLongitude);
		
		// Champ Type
		txtType = new JTextField("Type: WATER || FIRE ||CHEM");
		panelChamps.add(txtType);
		

		// Panel Champs & Buttons
		JPanel CandB = new JPanel();
		CandB.setLayout(new BorderLayout());
		CandB.add(panelButton,BorderLayout.NORTH);
        CandB.add(panelChamps,BorderLayout.SOUTH);
		
		
		//ajout de la table et du panel des boutons
		panel.add(new JScrollPane(table),BorderLayout.CENTER);
		panel.add(CandB,BorderLayout.SOUTH);
        
		setContentPane(panel);
		
		
		// Config de la JFrame
		setTitle("Liste des Sources");
		pack();
		setVisible(true);
		
	}
	
	
	public String getID(){
		return txtId.getText();
	}
	
	public String getLatitude(){
		return txtLatitude.getText();
	}
	
	public String getLongitude(){
		return txtLongitude.getText();
	}
	
	public void resetTxtFields(){
		txtId.setText("ID");
		txtLatitude.setText("Latitude");
		txtLongitude.setText("Longitude");
	}
	
	public int getSelectedLine(){
		return table.getSelectedRow();
	}


	public SourceType getSourceType() {
		String type = txtType.getText();
		if (type.equals("WATER")) return SourceDTO.SourceType.WATER;
		if (type.equals("FIRE")) return SourceDTO.SourceType.FIRE;
		if (type.equals("CHEM")) return SourceDTO.SourceType.CHEM;
		else return null;
	}
}
