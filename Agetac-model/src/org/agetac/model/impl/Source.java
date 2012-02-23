package org.agetac.model.impl;

import org.agetac.model.exception.InvalidJSONException;
import org.agetac.model.sign.AbstractModel;
import org.json.JSONException;
import org.json.JSONObject;

public class Source extends AbstractModel {
	
	public Source(String uid, Position position) {
		super(uid, null, position);
	}

	public Source(JSONObject json) throws InvalidJSONException {
		super(json);
	}
	
	@Override
	public JSONObject toJSON() throws JSONException {
		return super.toJSON();
	}

	public String toString() {
		try {
			return this.toJSON().toString();
		} catch (JSONException e) {
			return "Error";
		}
	}
}
