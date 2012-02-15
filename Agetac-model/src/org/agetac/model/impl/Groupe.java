package org.agetac.model.impl;

import java.util.ArrayList;
import java.util.List;

import org.agetac.model.sign.AbstractModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Groupe extends AbstractModel {
	
	private Agent chef;
	private List<Vehicule> vehicules;

	public Groupe(String uid, Agent chef, List<Vehicule> vehicules) {
		super(uid, null, null);
		
		this.chef = chef;
		this.vehicules = vehicules;
	}

	public Groupe(JSONObject json) {
		super(json);
		
		try {
			this.chef = new Agent(json.getJSONObject("chef"));

			JSONArray jsar = json.getJSONArray("vehicules");
			vehicules = new ArrayList<Vehicule>();
			for (int i = 0; i < jsar.length(); i++) {
				vehicules.add(new Vehicule(jsar.getJSONObject(i)));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public JSONObject toJSON() {
		JSONObject json = super.toJSON();
		try {
			json.put("chef", chef.toJSON());
			json.put("vehicules", vehicules);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	
	@Override
	public Position getPosition(){
		if(vehicules.get(0) != null){
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
