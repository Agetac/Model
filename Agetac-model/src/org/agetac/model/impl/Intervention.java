package org.agetac.model.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;

import org.agetac.model.exception.InvalidJSONException;
import org.agetac.model.sign.AbstractModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@PersistenceCapable
public class Intervention extends AbstractModel {

	@NotPersistent
	private List<Vehicule> vehicules;
	
	@NotPersistent
	private List<Cible> cibles;
	
	@NotPersistent
	private List<Source> sources;
	
	@NotPersistent
	private List<Action> actions;
	
	@NotPersistent
	private List<Message> messages;
	
	@NotPersistent
	private List<Implique> impliques;

	public Intervention() {
		super(null, null, new Position(0, 0));
		this.vehicules = new ArrayList<Vehicule>();
		this.cibles = new ArrayList<Cible>();
		this.sources = new ArrayList<Source>();
		this.actions = new ArrayList<Action>();
		this.messages = new ArrayList<Message>();
		this.impliques = new ArrayList<Implique>();
	}

	public Intervention(String uid) {
		super(uid, null, new Position(0, 0));
		this.vehicules = new ArrayList<Vehicule>();
		this.cibles = new ArrayList<Cible>();
		this.sources = new ArrayList<Source>();
		this.actions = new ArrayList<Action>();
		this.messages = new ArrayList<Message>();
		this.impliques = new ArrayList<Implique>();
	}

	public Intervention(JSONObject json) throws InvalidJSONException {
		super(json);

		this.vehicules = new ArrayList<Vehicule>();
		this.cibles = new ArrayList<Cible>();
		this.sources = new ArrayList<Source>();
		this.actions = new ArrayList<Action>();
		this.messages = new ArrayList<Message>();
		this.impliques = new ArrayList<Implique>();

		try {
			JSONArray jsar = json.getJSONArray("vehicules");
			for (int i = 0; i < jsar.length(); i++) {
				vehicules.add(new Vehicule(jsar.getJSONObject(i)));
			}

			jsar = json.getJSONArray("cibles");
			for (int i = 0; i < jsar.length(); i++) {
				cibles.add(new Cible(jsar.getJSONObject(i)));
			}

			jsar = json.getJSONArray("sources");
			for (int i = 0; i < jsar.length(); i++) {
				sources.add(new Source(jsar.getJSONObject(i)));
			}

			jsar = json.getJSONArray("actions");
			for (int i = 0; i < jsar.length(); i++) {
				actions.add(new Action(jsar.getJSONObject(i)));
			}

			jsar = json.getJSONArray("messages");
			for (int i = 0; i < jsar.length(); i++) {
				messages.add(new Message(jsar.getJSONObject(i)));
			}

			jsar = json.getJSONArray("impliques");
			for (int i = 0; i < jsar.length(); i++) {
				impliques.add(new Implique(jsar.getJSONObject(i)));
			}
		} catch (JSONException e) {
			throw new InvalidJSONException(json.toString());
		}
	}

	public String toString() {
		try {
			return this.toJSON().toString();
		} catch (JSONException e) {
			return "Error";
		}
	}

	@Override
	public JSONObject toJSON() throws JSONException {
		JSONObject json = super.toJSON();

		JSONArray array_vehicules = new JSONArray();
		if (this.vehicules != null) {
			for (int i = 0; i < this.vehicules.size(); i++) {
				array_vehicules.put(i, this.vehicules.get(i).toJSON());
			}
		}
		json.put("vehicules", array_vehicules);

		JSONArray array_cibles = new JSONArray();
		if (this.cibles != null) {
			for (int i = 0; i < this.cibles.size(); i++) {
				array_cibles.put(i, this.cibles.get(i).toJSON());
			}
		}
		json.put("cibles", array_cibles);

		JSONArray array_sources = new JSONArray();
		if (this.sources != null) {
			for (int i = 0; i < this.sources.size(); i++) {
				array_sources.put(i, this.sources.get(i).toJSON());
			}
		}
		json.put("sources", array_sources);

		JSONArray array_actions = new JSONArray();
		if (this.actions != null) {
			for (int i = 0; i < this.actions.size(); i++) {
				array_actions.put(i, this.actions.get(i).toJSON());
			}
		}
		json.put("actions", array_actions);

		JSONArray array_messages = new JSONArray();
		if (this.messages != null) {
			for (int i = 0; i < this.messages.size(); i++) {
				array_messages.put(i, this.messages.get(i).toJSON());
			}
		}
		json.put("messages", array_messages);

		JSONArray array_impliques = new JSONArray();
		if (this.impliques != null) {
			for (int i = 0; i < this.impliques.size(); i++) {
				array_impliques.put(i, this.impliques.get(i).toJSON());
			}
		}
		json.put("impliques", array_impliques);

		return json;
	}

	/*
	 * GETTER & SETTER
	 */
	public List<Vehicule> getVehicules() {
		return vehicules;
	}

	public void setVehicules(List<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}

	public List<Cible> getCibles() {
		return cibles;
	}

	public void setCibles(List<Cible> cibles) {
		this.cibles = cibles;
	}

	public List<Source> getSources() {
		return sources;
	}

	public void setSources(List<Source> sources) {
		this.sources = sources;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<Implique> getImpliques() {
		return impliques;
	}

	public void setImpliques(List<Implique> impliques) {
		this.impliques = impliques;
	}
}
