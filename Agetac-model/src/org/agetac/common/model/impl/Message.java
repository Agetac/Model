package org.agetac.common.model.impl;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Message {
	
	private String uniqueID;
	private String message;
	private String date;
	private Intervention intervention;
	
	public Message(String uniqueID, String message, String date) {
		if(uniqueID == null){
			this.uniqueID = "";
		}else{
			this.uniqueID = uniqueID;
		}
		this.message = message;
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

}
