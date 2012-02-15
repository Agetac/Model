package org.agetac.model.impl;

import java.util.HashMap;

import org.agetac.model.sign.AbstractModel;
import org.agetac.model.sign.IJsonable;
import org.json.JSONException;
import org.json.JSONObject;

public class Vehicule extends AbstractModel {

	public enum EtatVehicule {
	    DISPO_CASERNE, ALERTE, PARTIS, SUR_LES_LIEUX, TRANSPORT_HOPITAL, DISPO_RADIO, TEMPS_DEPASSE
	}
	
	private Caserne caserne;
	private EtatVehicule etat;
	private Groupe groupe;
	private HashMap<String, String> groupesHoraires; 

	public Vehicule(String uid, String nom, Position position, Caserne caserne, EtatVehicule etat, Groupe groupe) {
		super(uid, nom, position);
		this.caserne = caserne;
		this.etat = etat;
		this.groupe = groupe;
		this.groupesHoraires = new HashMap<String, String>();
		groupesHoraires.put("demande", "");
		groupesHoraires.put("arrivee", "");
		groupesHoraires.put("depart", "");
	}
	
	public Vehicule(JSONObject json) {
		super(json);
		try {
			this.caserne = new Caserne(json.getJSONObject("caserne"));
			this.etat = EtatVehicule.valueOf(json.getString("etat"));
			this.groupe = new Groupe(json.getJSONObject("groupe"));
			// vu que Marie et Gildas ont rajouté groupesHoraires il faudrait compléter
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public Caserne getCaserne() {
		return caserne;
	}
	
	public void setCaserne(Caserne caserne) {
		this.caserne = caserne;
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

	public HashMap<String, String> getGroupesHoraires() {
		return groupesHoraires;
	}

	public void setGroupesHoraires(HashMap<String, String> groupesHoraires) {
		this.groupesHoraires = groupesHoraires;
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
		sb.append(",position:");
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
