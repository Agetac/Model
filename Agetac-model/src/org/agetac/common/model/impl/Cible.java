package org.agetac.common.model.impl;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

import org.agetac.common.model.sign.AbstractModel;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Cible extends AbstractModel {
	
	private Intervention intervention;
	
	public Cible() {
		super(null,new Position(0,0));
	}
	
	public Cible(Position position) {
		super(null, position);
	}
}
