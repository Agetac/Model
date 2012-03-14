package org.agetac.common.model.impl;

import org.agetac.common.exception.InvalidJSONException;
import org.agetac.common.model.sign.AbstractModel;
import org.json.JSONException;
import org.json.JSONObject;

public class Cible extends AbstractModel {
	
	public Cible(String uid, Position position) {
		super(uid, null, position);
	}

	public Cible(JSONObject json) throws InvalidJSONException{
		super(json);
	}
	
	@Override
	public JSONObject toJSON() throws JSONException{
		return super.toJSON();
	}

	/**
	 * Convert this object to a string for representation
	 */
	public String toString() {
		
		try {
			return this.toJSON().toString();
		} catch (JSONException e) {
			return "Error";
		}
	}

}
