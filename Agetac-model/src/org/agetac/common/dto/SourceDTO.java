package org.agetac.common.dto;

import java.util.Observer;

import org.agetac.common.observer.MyObservable;


public class SourceDTO implements IModel {

	private long id;
	
	public enum SourceType {WATER, FIRE, CHEM}
	
	private SourceType type;
	private PositionDTO position;
	private String name = "";
	
	private MyObservable observable = new MyObservable();
	
	public SourceDTO() {
		this.type = SourceType.FIRE;
	}
	
	public SourceDTO(SourceType type) {
		this.type = type;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public SourceDTO(String name, SourceType type, PositionDTO p) {
		this.name = name;
		this.type = type;
		this.position = p;
	}

	public SourceDTO(PositionDTO p, SourceType t) {
		this.position = p;
		this.type = t;
	}

	public SourceType getType() {
		return type;
	}

	public void setType(SourceType type) {
		this.type = type;
	}

	public PositionDTO getPosition() {
		return position;
	}

	public void setPosition(PositionDTO position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void addObserver(Observer obs) {
		observable.addObserver(obs);
	}
}
