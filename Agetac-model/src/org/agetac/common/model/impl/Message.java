package org.agetac.common.model.impl;

import org.agetac.common.model.sign.IJsonable;
import org.json.JSONException;
import org.json.JSONObject;

public class Message implements IJsonable {
	
	private String uniqueID;
	private String message;
	private String date;

	public Message(String uniqueID, String message, String date) {
		if(uniqueID == null){
			this.uniqueID = "";
		}else{
			this.uniqueID = uniqueID;
		}
		this.message = message;
		this.date = date;
	}

	public Message(JSONObject json) {
		
		try {
			this.setUniqueID(json.getString("uniqueID"));
			this.message = json.getString("message");
			this.date = json.getString("date");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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


	/**
	 * Cree un JSONObject representant le Message
	 * @throws JSONException 
	 */
	public JSONObject toJSON() throws JSONException {

		JSONObject json = new JSONObject();

		json.put("uniqueID", this.uniqueID);
		json.put("message", this.message);
		json.put("date", this.date);


		return json;
	}

	public String toString() {
		try {
			return this.toJSON().toString(4);
		} catch (JSONException e) {
			return "Error";
		}
	}

}
