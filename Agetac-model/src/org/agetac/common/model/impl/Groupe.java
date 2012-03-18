package org.agetac.common.model.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

import org.agetac.common.model.sign.AbstractModel;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Groupe extends AbstractModel {
	
	private Agent chef;
	private List<Vehicule> vehicules;

	public Groupe() {
		super(null, null);
		this.chef = null;
		this.vehicules = new ArrayList<Vehicule>();
	}
	
	public Groupe(Agent chef, List<Vehicule> vehicules) {
		super(null, null);
		
		this.chef = chef;
		this.vehicules = vehicules;
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
