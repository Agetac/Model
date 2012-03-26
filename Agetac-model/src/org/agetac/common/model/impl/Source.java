package org.agetac.common.model.impl;

import org.agetac.common.exception.InvalidJSONException;
import org.agetac.common.model.impl.Cible.CibleType;
import org.agetac.common.model.impl.Source.SourceType;
import org.agetac.common.model.sign.AbstractModel;
import org.json.JSONException;
import org.json.JSONObject;

public class Source extends AbstractModel {
	
	public enum SourceType {
		WATER,
		FIRE,
		CHEM
	}
	
	private SourceType type;
	
	public Source() {
		super(null, null, new Position(0,0));
		this.type = SourceType.WATER;
	}
	
	public Source(String uid, Position position, SourceType type) {
		super(uid, null, position);
		this.type = type;
	}

	public Source(JSONObject json) throws InvalidJSONException {
		super(json);
		
		try {
			this.type = SourceType.valueOf(json.getString("type"));
		} catch (JSONException e) {
			throw new InvalidJSONException(json.toString());
		}
	}
	
	public Source(SourceType type) {
		super(null, null, new Position(0,0));
		this.type = type;
	}

	@Override
	public JSONObject toJSON() throws JSONException {
		JSONObject json = super.toJSON();
		json.put("type", this.type.name());
		return json;
	}
	
	public SourceType getType() {
		return type;
	}
	
	public void setType(SourceType t) {
		this.type = t;
	}

	public String toString() {
		try {
			return this.toJSON().toString(4);
		} catch (JSONException e) {
			return "Error";
		}
	}
}
