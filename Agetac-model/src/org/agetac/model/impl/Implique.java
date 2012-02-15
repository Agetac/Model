package org.agetac.model.impl;

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

	public Implique(JSONObject json) {
		super(json);
		
		try {
			this.etat = EtatImplique.valueOf(json.getString("etat"));
		} catch (JSONException e) {
			e.printStackTrace();
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
		StringBuffer sb = new StringBuffer();
		sb.append("etat:");
		sb.append(this.etat);
		return sb.toString();
	}

	/**
	 * Convert this object to a JSON object for representation
	 */
	@Override
	public JSONObject toJSON() {
		JSONObject json = super.toJSON();
		try {
			json.put("etat", etat.name());

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
	}

}
