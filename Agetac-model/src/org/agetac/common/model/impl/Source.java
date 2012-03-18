package org.agetac.common.model.impl;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

import org.agetac.common.model.sign.AbstractModel;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Source extends AbstractModel {
	
	private Intervention intervention;
	
	public Source() {
		super(null, null);
	}
	
	public Source(Position position) {
		super(null, position);
	}
}
