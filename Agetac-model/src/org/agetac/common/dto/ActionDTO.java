package org.agetac.common.dto;

import java.util.Observer;

import org.agetac.common.observer.MyObservable;


public class ActionDTO implements IModel {

	public enum ActionType {WATER, FIRE, HUMAN, CHEM}
	
	private long id;
	private String name = "";
	private ActionType type;
	private PositionDTO position;
	private PositionDTO origin;
	private PositionDTO aim;
	
	private MyObservable observable = new MyObservable();
	
	public ActionDTO() {}
	
	public ActionDTO(ActionType type) {
		this.type = type;
	}
	
	public ActionDTO(String n, ActionType t, PositionDTO p, PositionDTO a) {
		this.name = n;
		this.type = t;
		this.position = p;
		this.origin = p;
		this.aim = a;
	}
	
	public ActionDTO(PositionDTO p, ActionType t, PositionDTO origin, PositionDTO aim) {
		this.name = "action";
		this.position = p;
		this.type = t;
		this.origin = origin;
		this.aim = aim;
	}

	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ActionType getType() {
		return type;
	}

	public void setType(ActionType type) {
		this.type = type;
	}

	public PositionDTO getPosition() {
		return position;
	}

	public void setPosition(PositionDTO position) {
		this.position = position;
	}

	public PositionDTO getAim() {
		return aim;
	}

	public void setAim(PositionDTO aim) {
		this.aim = aim;
	}

	public PositionDTO getOrigin() {
		return origin;
	}

	public void setOrigin(PositionDTO origin) {
		this.origin = origin;
	}

	public void setId(long id) {
		this.id = id;		
	}

	@Override
	public void addObserver(Observer obs) {
		observable.addObserver(obs);
	}
	
}
