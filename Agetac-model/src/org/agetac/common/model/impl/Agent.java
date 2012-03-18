package org.agetac.common.model.impl;

import java.util.List;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

import org.agetac.common.model.sign.AbstractModel;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
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
		super(null, null);
		this.aptitude = null;
		this.subordonnes = null;
	}

	public Agent(String name, Aptitude aptitude, List<Agent> subordonnes) {
		super(name, null);
		this.aptitude = aptitude;
		this.subordonnes = subordonnes;
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

}
