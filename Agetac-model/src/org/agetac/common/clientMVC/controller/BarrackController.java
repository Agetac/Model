package org.agetac.common.clientMVC.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.agetac.common.clientMVC.model.BarrackModel;
import org.agetac.common.clientMVC.view.BarrackView;
import org.agetac.common.dto.BarrackDTO;

public class BarrackController implements ActionListener {

	private BarrackView view;
	private BarrackModel model;

	/**
	 * Constructeur de CaserneController
	 */
	public BarrackController(BarrackView view, BarrackModel model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Ajouter une caserne")) {
			if (!(view.getID().equals("ID")) && !(view.getNom().equals("Nom")) && !(view.getMoyens().equals("Moyens"))){
			model.addBarrack(new BarrackDTO(view.getNom()));
			view.resetTxtFields();
			}
		}
		else if (e.getActionCommand().equals("Supprimer une caserne")) {
			model.removeBarrack(view.getSelectedLine());
		}
	}

}
