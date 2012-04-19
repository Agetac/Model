package org.agetac.common.dto;

import java.util.Observer;

import org.agetac.common.observer.MyObservable;

public class VictimDTO implements IModel {

	private long id;
	private PositionDTO position;
	private String name = "";
	
	private MyObservable observable = new MyObservable();

	public VictimDTO() {}

	public VictimDTO(String name, PositionDTO position) {
		this.name = name;
		this.position = position;
		observable.setChanged();
		observable.notifyObservers(this);
	}
	
	public long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
		observable.setChanged();
		observable.notifyObservers(this);
	}

	public String getName() {
		return name;
	}

	@Override
	public PositionDTO getPosition() {
		return position;
	}

	@Override
	public void setPosition(PositionDTO p) {
		this.position = p;
		observable.setChanged();
		observable.notifyObservers(this);
	}

	@Override
	public void addObserver(Observer obs) {
		observable.addObserver(obs);
	}
}
