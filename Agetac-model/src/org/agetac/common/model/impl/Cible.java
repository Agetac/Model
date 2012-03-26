package org.agetac.common.model.impl;

import java.util.ArrayList;

import org.agetac.common.exception.InvalidJSONException;
import org.agetac.common.model.impl.Agent.Aptitude;
import org.agetac.common.model.impl.Cible.CibleType;
import org.agetac.common.model.sign.AbstractModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Cible extends AbstractModel {
	
	public enum CibleType {
		WATER,
		FIRE,
		CHEM,
		HUMAN
	}
	
	private CibleType type;
	
	public Cible() {
		super(null,null,new Position(0,0));
		this.type = CibleType.WATER;
	}
	
	public Cible(String uid, Position position, CibleType type) {
		super(uid, null, position);
		this.type = type;
	}

	public Cible(JSONObject json) throws InvalidJSONException{
		super(json);
		
		try {
			this.type = CibleType.valueOf(json.getString("type"));
		} catch (JSONException e){
			throw new InvalidJSONException(json.toString());
		}
	}
	
	public Cible(CibleType type) {
		super(null,null,new Position(0,0));
		this.type = type;
	}

	@Override
	public JSONObject toJSON() throws JSONException{
		JSONObject json = super.toJSON();
		json.put("type", this.type.name());
		return json;
	}
	
	public CibleType getType() {
		return type;
	}
	
	public void setType(CibleType t) {
		this.type = t;
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
