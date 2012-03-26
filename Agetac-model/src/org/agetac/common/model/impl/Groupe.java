package org.agetac.common.model.impl;

import java.util.ArrayList;
import java.util.List;

import org.agetac.common.exception.InvalidJSONException;
import org.agetac.common.model.sign.AbstractModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Groupe extends AbstractModel {
	
	private Agent chef;
	private List<Vehicule> vehicules;

	public Groupe() {
		super(null, null, null);
		this.chef = null;
		this.vehicules = new ArrayList<Vehicule>();
	}
	
	public Groupe(String uid, Agent chef, List<Vehicule> vehicules) {
		super(uid, null, null);
		
		this.chef = chef;
		this.vehicules = vehicules;
	}

	public Groupe(JSONObject json) throws InvalidJSONException {
		super(json);
		try{
			this.chef = new Agent(json.getJSONObject("chef"));
	
			JSONArray jsar = json.getJSONArray("vehicules");
			vehicules = new ArrayList<Vehicule>();
			for (int i = 0; i < jsar.length(); i++) {
				vehicules.add(new Vehicule(jsar.getJSONObject(i)));
			}
		}catch(JSONException e){
			throw new InvalidJSONException(json.toString());
		}
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
		JSONObject json = super.toJSON();
		
		json.put("chef", chef.toJSON());
		
		JSONArray array = new JSONArray();
		if(this.vehicules != null){
			for(int i = 0; i < this.vehicules.size(); i++){
				array.put(i, this.vehicules.get(i).toJSON());
			}
		}
		
		json.put("vehicules", array);

		return json;
	}
	
	
	@Override
	public Position getPosition(){
		if(!vehicules.isEmpty() && vehicules.get(0) != null){
			return vehicules.get(0).getPosition();
		}
		else return super.getPosition();
	}
	
	
	public List<Vehicule> getMoyens() {
		return vehicules;
	}

	public void setMoyens(List<Vehicule> moyens) {
		this.vehicules = moyens;
	}

	public Agent getChef() {
		return chef;
	}

	public void setChef(Agent chef) {
		this.chef = chef;
	}



}
