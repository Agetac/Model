package org.agetac.common;

import org.json.JSONException;
import org.json.JSONObject;

public class Moyen {
	private String nom;
	private Caserne caserne;
	private Position position;

	public Moyen(String nom, Position position) {
		super();
		this.nom = nom;
		this.position = position;
	}
	public Moyen(JSONObject json){
		try {
			this.nom = json.getString("nom");
			this.position = new Position(json.getJSONObject("position"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Caserne getCaserne() {
		return caserne;
	}

	public void setCaserne(Caserne caserne) {
		this.caserne = caserne;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * Convert this object to a string for representation
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("nom:");
		sb.append(this.nom);
		sb.append(",caserne:");
		sb.append(this.caserne);
		sb.append(",position:");
		sb.append(this.position);
		return sb.toString();
	}

	/**
	 * Convert this object to a JSON object for representation
	 */
	public JSONObject toJSON() {
		try {
			JSONObject jsonobj = new JSONObject();
			jsonobj.put("nom", this.nom);
			jsonobj.put("caserne", this.caserne);
			jsonobj.put("position", this.position);
			return jsonobj;
		} catch (Exception e) {
			return null;
		}
	}
}
