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
	
	public Action() {
		super(null,null,new Position(0,0));
		this.actionType = null;
		this.origin = new Position(0,0);
		this.aim = new Position(0,0);
	}
	
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
			return this.toJSON().toString(4);
		} catch (JSONException e) {
			return "Error";
		}
	}

	public JSONObject toJSON() throws JSONException {
		JSONObject json = super.toJSON();
		
		json.put("actionType", actionType.name());
		json.put("origin", origin.toJSON());
		json.put("aim", aim.toJSON());
		return json;	
	}
	
	public void setOrigin(Position origin) {
		this.origin = origin;
	}
	public void setAim(Position aim) {
		this.aim = aim;
	}
	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}
	
	public Position getOrigin() {
		return origin;
	}
	public Position getAim() {
		return aim;
	}
	
	public ActionType getActionType() {
		return actionType;
	}


}
