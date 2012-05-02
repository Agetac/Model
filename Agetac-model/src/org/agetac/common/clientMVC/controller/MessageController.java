package org.agetac.common.clientMVC.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.agetac.common.clientMVC.model.MessageModel;
import org.agetac.common.clientMVC.view.MessageView;
import org.agetac.common.dto.MessageDTO;

public class MessageController implements ActionListener {

	private MessageView view;
	private MessageModel model;

	/**
	 * MessageController constructor
	 */
	public MessageController(MessageView view, MessageModel model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Add message")) {
			if (!(view.getMessage().equals("Message")) && !(view.getDate().equals("Date"))){
			model.addMessage(new MessageDTO(view.getMessage(), view.getDate()));
			view.resetTxtFields();
			}
		}
	}
}
