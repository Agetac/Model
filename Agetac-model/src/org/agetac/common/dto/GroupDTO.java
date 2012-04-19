package org.agetac.common.dto;

import java.util.Observer;

import org.agetac.common.observer.MyObservable;

public class GroupDTO implements IModel {

	private long id;
	private PositionDTO position;
	private String name = "";
	
	private MyObservable observable = new MyObservable();
	

	public GroupDTO() {
	}
	
	public GroupDTO(String name, PositionDTO position) {
		this.name = name;
		this.position = position;
	}
	
	@Override
	public long getId() {
		return id;
	}
	
	@Override
	public PositionDTO getPosition() {
		return position;
	}

	@Override
	public void setPosition(PositionDTO p) {
		this.position = p;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void addObserver(Observer obs) {
		observable.addObserver(obs);
	}
	
}
