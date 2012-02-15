package org.agetac.model.impl;

import org.agetac.model.sign.AbstractModel;
import org.agetac.model.sign.IJsonable;
import org.json.JSONException;
import org.json.JSONObject;

public class Vehicule extends AbstractModel {

	public enum EtatVehicule {
	    DISPO_CASERNE, ALERTE, PARTIS, SUR_LES_LIEUX, TRANSPORT_HOPITAL, DISPO_RADIO, TEMPS_DEPASSE
	}
	
	private String caserneName;
	private EtatVehicule etat;
	private Groupe groupe;
	

	public Vehicule(String uid, String nom, Position position, String caserneName, EtatVehicule etat, Groupe groupe) {
		super(uid, nom, position);
		this.caserneName = caserneName;
		this.etat = etat;
		this.groupe = groupe;
	}
	
	public Vehicule(JSONObject json) {
		super(json);
		try {
			this.caserneName = json.getString("caserneName");
			this.etat = EtatVehicule.valueOf(json.getString("etat"));
			this.groupe = new Groupe(json.getJSONObject("groupe"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public String getCaserneName() {
		return caserneName;
	}
	
	public void setCaserneName(String caserneName) {
		this.caserneName = caserneName;
	}

	public EtatVehicule getEtat() {
		return etat;
	}

	public void setEtat(EtatVehicule etat) {
		this.etat = etat;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	/**
	 * Convert this object to a string for representation
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append("etat:");
		sb.append(this.etat);
		sb.append(",groupe:");
		sb.append(this.groupe);
		sb.append(",caserneName:");
		sb.append(this.caserneName);
		return sb.toString();
	}

	/**
	 * Convert this object to a JSON object for representation
	 */
	public JSONObject toJSON() {
		JSONObject json = null;
		
		try {
			json = super.toJson();
			json.put("etat", this.etat.name());
			json.put("groupe", this.groupe);
			json.put("caserneName", this.caserneName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return json;
	}

	@Override
	public IJsonable fromJson(JSONObject json) {
		// TODO Auto-generated method stub
		return null;
	}
}