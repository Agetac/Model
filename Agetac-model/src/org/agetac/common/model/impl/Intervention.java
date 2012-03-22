package org.agetac.common.model.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.agetac.common.model.sign.AbstractModel;

@PersistenceCapable(detachable = "false")
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Intervention extends AbstractModel {

	@Persistent(mappedBy = "intervention", defaultFetchGroup = "true")
	private List<Vehicule> vehicules = new ArrayList<Vehicule>();

	@Persistent(mappedBy = "intervention", defaultFetchGroup = "true")
	private List<Cible> cibles = new ArrayList<Cible>();

	@Persistent(mappedBy = "intervention", defaultFetchGroup = "true")
	private List<Source> sources = new ArrayList<Source>();

	@Persistent(mappedBy = "intervention", defaultFetchGroup = "true")
	private List<Action> actions = new ArrayList<Action>();

	@Persistent(mappedBy = "intervention", defaultFetchGroup = "true")
	private List<Message> messages = new ArrayList<Message>();

	@Persistent(mappedBy = "intervention", defaultFetchGroup = "true")
	private List<Implique> impliques = new ArrayList<Implique>();

	public Intervention() {
		super(null, new Position(0, 0));
	}

	/*
	 * GETTER & SETTER
	 */
	public List<Vehicule> getVehicules() {
		return vehicules;
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
