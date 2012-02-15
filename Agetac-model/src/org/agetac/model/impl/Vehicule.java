package org.agetac.model.impl;

import java.util.HashMap;

import org.agetac.model.sign.AbstractModel;
import org.json.JSONException;
import org.json.JSONObject;

public class Vehicule extends AbstractModel {

	public enum EtatVehicule {
	    DISPO_CASERNE, ALERTE, PARTIS, SUR_LES_LIEUX, TRANSPORT_HOPITAL, DISPO_RADIO, TEMPS_DEPASSE
	}
	
	private String caserneName;
	private EtatVehicule etat;
	private Groupe groupe;
	private HashMap<EtatVehicule, String> groupesHoraires; 

	public Vehicule(String uid, String nom, Position position, String caserneName, EtatVehicule etat, Groupe groupe) {
		super(uid, nom, position);
		this.caserneName = caserneName;
		this.etat = etat;
		this.groupe = groupe;
		this.groupesHoraires = new HashMap<EtatVehicule, String>();
	}
	
	public Vehicule(JSONObject json) throws JSONException {
		super(json);
		try {
			this.etat = EtatVehicule.valueOf(json.getString("etat"));
			this.groupe = new Groupe(json.getJSONObject("groupe"));
			this.caserneName = json.getString("caserneName");
			// vu que Marie et Gildas ont rajoute groupesHoraires il faudrait completer
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

	public HashMap<EtatVehicule, String> getGroupesHoraires() {
		return groupesHoraires;
	}

	public void setGroupesHoraires(HashMap<EtatVehicule, String> groupesHoraires) {
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
		sb.append(",caserneName:");
		sb.append(this.caserneName);
		return sb.toString();
	}

	/**
	 * Convert this object to a JSON object for representation
	 */
	public JSONObject toJSON() {
		JSONObject json = null;
		json = super.toJSON();
		try {
			
			json.put("etat", this.etat.name());
			json.put("groupe", this.groupe.toJSON());
			json.put("caserneName", this.caserneName);
			System.out.println(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return json;
	}

}
