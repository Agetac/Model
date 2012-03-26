package org.agetac.common.model.impl;

import java.util.ArrayList;
import java.util.List;

import org.agetac.common.exception.InvalidJSONException;
import org.agetac.common.model.sign.AbstractModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Agent extends AbstractModel {

	public enum Aptitude {
	    COS,
	    CA,
	    CDG,
	    CDC,
	    AGENT
	}
	
	private Aptitude aptitude;
	private List<Agent> subordonnes;

	public Agent() {
		super(null, null, null);
		this.aptitude = null;
		this.subordonnes = null;
	}

	public Agent(String uid, String name, Aptitude aptitude, List<Agent> subordonnes) {
		super(uid, name, null);
		this.aptitude = aptitude;
		this.subordonnes = subordonnes;
	}

	public Agent(JSONObject json) throws InvalidJSONException {
		super(json);
		
		try{
			this.aptitude = Aptitude.valueOf(json.getString("aptitude"));
			JSONArray array = json.getJSONArray("subordonnes");
			
			this.subordonnes = new ArrayList<Agent>();
			for (int i=0; i<array.length(); i++) {
				this.subordonnes.add(new Agent(array.getJSONObject(i)));
			}
		}catch (JSONException e){
			throw new InvalidJSONException(json.toString());
		}

	}
	

	/**
	 * Convert this object to a JSON object for representation
	 * @throws JSONException 
	 */
	public JSONObject toJSON() throws JSONException {
		
		JSONObject json = super.toJSON();
		
		json.put("aptitude", aptitude.name());
		JSONArray array = new JSONArray();
		
		if(this.subordonnes != null){
			for(int i = 0; i < this.subordonnes.size(); i++){
				array.put(i, this.subordonnes.get(i).toJSON());
			}
		}
		
		json.put("subordonnes", array);

		return json;
	}
	
	public Aptitude getAptitude() {
		return aptitude;
	}

	public void setAptitude(Aptitude aptitude) {
		this.aptitude = aptitude;
	}

	public List<Agent> getSubordonnes() {
		return subordonnes;
	}

	public void setSubordonnes(List<Agent> subordonnes) {
		this.subordonnes = subordonnes;
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


}
