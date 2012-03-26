package org.agetac.common.model.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;

import org.agetac.common.exception.InvalidJSONException;
import org.agetac.common.model.sign.AbstractModel;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Intervention extends AbstractModel {

	private List<Vehicule> vehicules;
	private List<Cible> cibles;
	private List<Source> sources;
	private List<Action> actions;
	private List<Message> messages;
	private List<Implique> impliques;
	private List<DemandeMoyen> demandes_moyen;


	public Intervention() {
		super(null, null, new Position(0, 0));
		this.vehicules = new ArrayList<Vehicule>();
		this.cibles = new ArrayList<Cible>();
		this.sources = new ArrayList<Source>();
		this.actions = new ArrayList<Action>();
		this.messages = new ArrayList<Message>();
		this.impliques = new ArrayList<Implique>();
		this.demandes_moyen = new ArrayList<DemandeMoyen>();
	}

	public Intervention(String uid) {
		super(uid, null, new Position(0, 0));
		this.vehicules = new ArrayList<Vehicule>();
		this.cibles = new ArrayList<Cible>();
		this.sources = new ArrayList<Source>();
		this.actions = new ArrayList<Action>();
		this.messages = new ArrayList<Message>();
		this.impliques = new ArrayList<Implique>();
		this.demandes_moyen = new ArrayList<DemandeMoyen>();
	}

	public Intervention(JSONObject json) throws InvalidJSONException {
		super(json);

		this.vehicules = new ArrayList<Vehicule>();
		this.cibles = new ArrayList<Cible>();
		this.sources = new ArrayList<Source>();
		this.actions = new ArrayList<Action>();
		this.messages = new ArrayList<Message>();
		this.impliques = new ArrayList<Implique>();
		this.demandes_moyen = new ArrayList<DemandeMoyen>();

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
			
			jsar = json.getJSONArray("demandes_moyen");
			for (int i = 0; i < jsar.length(); i++) {
				demandes_moyen.add(new DemandeMoyen(jsar.getJSONObject(i)));
			}
		} catch (JSONException e) {
			throw new InvalidJSONException(json.toString());
		}
	}

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

		JSONArray array_demandes_moyen = new JSONArray();
		if (this.demandes_moyen != null) {
			for (int i = 0; i < this.demandes_moyen.size(); i++) {
				array_demandes_moyen.put(i, this.demandes_moyen.get(i).toJSON());
			}
		}
		json.put("demandes_moyen", array_demandes_moyen);
		
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
	
	public List<DemandeMoyen> getDemandesMoyen() {
		return demandes_moyen;
	}

	public void setDemandesMoyen(List<DemandeMoyen> demandes_moyen) {
		this.demandes_moyen = demandes_moyen;
	}
}
