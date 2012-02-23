package org.agetac.model.impl;

import org.agetac.model.exception.InvalidJSONException;
import org.agetac.model.sign.AbstractModel;
import org.json.JSONException;
import org.json.JSONObject;

public class Implique extends AbstractModel {

	public enum EtatImplique {
	    INDEMNE, URGENCE_RELATIVE, URGENCE_ABSOLUE, DECEDE 
	}
	
	private EtatImplique etat;

	public Implique(String uid, EtatImplique etat) {
		super(uid, null, null);
		this.etat = etat;
	}

	public Implique(JSONObject json) throws InvalidJSONException {
		super(json);
		
		try {
			this.etat = EtatImplique.valueOf(json.getString("etat"));
		} catch (JSONException e) {
			throw new InvalidJSONException(json.toString());
		}
	}

	public EtatImplique getEtat() {
		return etat;
	}

	public void setEtat(EtatImplique etat) {
		this.etat = etat;
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

	/**
	 * Convert this object to a JSON object for representation
	 * @throws JSONException 
	 */
	@Override
	public JSONObject toJSON() throws JSONException {
		JSONObject json = super.toJSON();
		
		json.put("etat", etat.name());

		return json;
	}

}
