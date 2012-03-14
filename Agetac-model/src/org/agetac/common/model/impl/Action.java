package org.agetac.common.model.impl;

import org.agetac.common.exception.InvalidJSONException;
import org.agetac.common.model.impl.Agent.Aptitude;
import org.agetac.common.model.sign.AbstractModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Action extends AbstractModel {

	public enum ActionType {
		FIRE,
		WATER,
		VICTIM
	}
	
	private ActionType actionType;
	private Position origin, aim;
	
	public Action(String uid, Position position, ActionType actionType, Position origin, Position aim) {
		super(uid, null, position);
		this.actionType = actionType;
		this.origin = origin;
		this.aim = aim;
	}

	public Action(JSONObject json) throws InvalidJSONException, JSONException {
		super(json);
		this.actionType = ActionType.valueOf(json.getString("actionType"));
		this.origin = new Position(json.getJSONObject("origin"));
		this.aim = new Position(json.getJSONObject("aim"));
		
	}

	public String toString() {
		try {
			return this.toJSON().toString();
		} catch (JSONException e) {
			return "Error";
		}
	}

	public JSONObject toJSON() throws JSONException {
		JSONObject json = super.toJSON();
		
		json.put("actionType", actionType.name());
		
		json.put("origin", origin.toJSON());
		json.put("aim", aim.toJSON());

		return json;	}

}
