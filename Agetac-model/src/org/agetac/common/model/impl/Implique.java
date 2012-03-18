package org.agetac.common.model.impl;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

import org.agetac.common.model.sign.AbstractModel;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Implique extends AbstractModel {

	public enum EtatImplique {
	    INDEMNE, URGENCE_RELATIVE, URGENCE_ABSOLUE, DECEDE 
	}

	private Intervention intervention;
	
	private EtatImplique etat;

	public Implique(EtatImplique etat) {
		super(null, null);
		this.etat = etat;
	}

	public EtatImplique getEtat() {
		return etat;
	}

	public void setEtat(EtatImplique etat) {
		this.etat = etat;
	}
}
