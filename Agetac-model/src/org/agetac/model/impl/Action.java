package org.agetac.model.impl;

import org.agetac.model.exception.InvalidJSONException;
import org.agetac.model.sign.AbstractModel;
import org.json.JSONException;
import org.json.JSONObject;

public class Action extends AbstractModel {

	public Action(String uid, Position position) {
		super(uid, null, position);
	}

	public Action(JSONObject json) throws InvalidJSONException {
		super(json);
	}

	public String toString() {
		try {
			return this.toJSON().toString();
		} catch (JSONException e) {
			return "Error";
		}
	}

	public JSONObject toJSON() throws JSONException {
		return super.toJSON();
	}

}
