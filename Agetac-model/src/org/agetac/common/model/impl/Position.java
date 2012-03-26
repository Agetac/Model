package org.agetac.common.model.impl;

import org.agetac.common.exception.InvalidJSONException;
import org.agetac.common.model.sign.IJsonable;
import org.json.JSONException;
import org.json.JSONObject;

public class Position implements IJsonable {
	
	private double longitude;
	private double latitude;
	
	public Position() {
		longitude = 0;
		latitude = 0;
	}

	public Position(double longitude, double latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public Position(Position p) {
		this.longitude = p.getLongitude();
		this.latitude = p.getLatitude();
	}
	
	public Position(JSONObject json) throws InvalidJSONException{
		try {
			this.longitude = json.getDouble("longitude");
			this.latitude = json.getDouble("latitude");
		} catch (JSONException e) {
			throw new InvalidJSONException(json.toString());
		}
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@Override
	public JSONObject toJSON() throws JSONException {
		JSONObject json = new JSONObject();
		json.put("longitude", this.longitude);
		json.put("latitude", this.latitude);
		
		return json;
	}
	
	/**
	 * Convert this object to a string for representation
	 */
	public String toString() {
		try {
			return this.toJSON().toString(4);
		} catch (JSONException e) {
			return "Error";
		}
	}

}
