package org.agetac.common.model.impl;

import java.util.ArrayList;
import java.util.List;

import org.agetac.common.exception.InvalidJSONException;
import org.agetac.common.model.sign.AbstractModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Caserne extends AbstractModel {

	private List<Vehicule> vehicules;

	public Caserne(String uniqueID, String nom, List<Vehicule> vehicules) {
		super(uniqueID, nom, null);
		this.vehicules = vehicules;
	}

	public Caserne(JSONObject json) throws InvalidJSONException {
		super(json);
		
		try{
			JSONArray jsar = json.getJSONArray("moyens");
			for (int i = 0; i < jsar.length(); i++) {
				vehicules.add(new Vehicule(jsar.getJSONObject(i)));
			}
		}
		catch(JSONException e){
			throw new InvalidJSONException(json.toString());
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

	@Override
	public JSONObject toJSON() throws JSONException {
		JSONObject json = null;
		
		json = super.toJSON();
		JSONArray array = new JSONArray(vehicules);
		json.put("moyens", array);
		
		return json;
	}

}
