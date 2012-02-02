package org.agetac.model.impl;

import org.agetac.model.sign.AbstractModel;
import org.agetac.model.sign.IJsonable;
import org.json.JSONObject;

public class Cible extends AbstractModel {
	
	public Cible(String uid, Position position) {
		super(uid, null, position);
	}

	public Cible(JSONObject json) {
		super(json);
	}
	
	@Override
	public JSONObject toJson() {
		return super.toJson();
	}

	@Override
	public IJsonable fromJson(JSONObject json) {
		// TODO Auto-generated method stub
		return null;
	}
}
