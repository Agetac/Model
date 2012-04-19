package org.agetac.common.dto;

import java.util.Observer;

import org.agetac.common.observer.MyObservable;

public class BarrackDTO implements IModel {

	private long id;
	private String name;
	private PositionDTO position;
	
	private MyObservable observable = new MyObservable();
	
	public BarrackDTO() {}
	
	public BarrackDTO(String name) {
		this.name = name;
	}
	
	public long getId() {
		return id;
	}

	@Override
	public PositionDTO getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setPosition(PositionDTO p) {
		this.position = p;
		
	}

	@Override
	public void addObserver(Observer obs) {
		observable.addObserver(obs);
	}
	
}
