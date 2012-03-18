package org.agetac.common.model.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.agetac.common.model.sign.AbstractModel;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Intervention extends AbstractModel {

	@Persistent(mappedBy = "intervention")
	private List<Vehicule> vehicules;

	@Persistent(mappedBy = "intervention")
	private List<Cible> cibles;

	@Persistent(mappedBy = "intervention")
	private List<Source> sources;

	@Persistent(mappedBy = "intervention")
	private List<Action> actions;

	@Persistent(mappedBy = "intervention")
	private List<Message> messages;

	@Persistent(mappedBy = "intervention")
	private List<Implique> impliques;

	public Intervention() {
		super(null, new Position(0, 0));
		this.vehicules = new ArrayList<Vehicule>();
		this.cibles = new ArrayList<Cible>();
		this.sources = new ArrayList<Source>();
		this.actions = new ArrayList<Action>();
		this.messages = new ArrayList<Message>();
		this.impliques = new ArrayList<Implique>();
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
