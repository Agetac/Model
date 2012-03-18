package org.agetac.common.model.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

import org.agetac.common.model.sign.AbstractModel;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Caserne extends AbstractModel {

	private List<Vehicule> vehicules;

	public Caserne(String nom, List<Vehicule> vehicules) {
		super(nom, null);
		this.vehicules = vehicules;
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
}
