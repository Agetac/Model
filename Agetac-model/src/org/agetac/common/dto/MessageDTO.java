package org.agetac.common.dto;

import java.util.Date;

public class MessageDTO {
	
	private long id;
	private String text;
	private Date date;
	
	public MessageDTO() {}
	
	public MessageDTO(String message, Date date) {
		this.text = message;
		this.date = date;
	}
	
	public long getId() {
		return id;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setId(long id) {
		this.id = id;
	}
}
