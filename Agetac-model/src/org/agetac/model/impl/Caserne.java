package org.agetac.model.impl;

import java.util.ArrayList;
import java.util.List;

import org.agetac.model.sign.AbstractModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Caserne extends AbstractModel {

	private List<Vehicule> vehicules;

	public Caserne(String uniqueID, String nom, List<Vehicule> vehicules) {
		super(uniqueID, nom, null);
		this.vehicules = vehicules;
	}

	public Caserne(JSONObject json) {
		super(json);
		try {
			JSONArray jsar = json.getJSONArray("moyens");
			for (int i = 0; i < jsar.length(); i++) {
				vehicules.add(new Vehicule(jsar.getJSONObject(i)));
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public List<Vehicule> getVehicules() {
		return vehicules;
	}

	public void setVehicules(ArrayList<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}

	public Vehicule requestVehicule() {
		if (!vehicules.isEmpty()) {
			Vehicule v = vehicules.get(0);
			vehicules.remove(0);
			return v;
			
		} else return null;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("nom:");
		sb.append(this.name);
		sb.append(", moyens:");
		sb.append(this.vehicules);
		return sb.toString();
	}

	@Override
	public JSONObject toJSON() {
		JSONObject json = null;
		
		try {
			json = super.toJSON();
			JSONArray array = new JSONArray(vehicules);
			json.put("moyens", array);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
	}

}
