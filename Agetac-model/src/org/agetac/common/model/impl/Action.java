package org.agetac.common.model.impl;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

import org.agetac.common.model.impl.Action.ActionType;
import org.agetac.common.model.sign.AbstractModel;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Action extends AbstractModel {

	public enum ActionType {
		FIRE, WATER, VICTIM
	}

	private Intervention intervention;
	
	private ActionType actionType;
	private Position origin, aim;

	public Action() {
		super(null, new Position(0, 0));
		this.actionType = null;
		this.origin = new Position(0, 0);
		this.aim = new Position(0, 0);
	}

	public Action(Position lineMiddlePos, ActionType fire,
			Position lineBeginPos, Position lineEndPos) {
		super(null, lineMiddlePos);
	}

}
