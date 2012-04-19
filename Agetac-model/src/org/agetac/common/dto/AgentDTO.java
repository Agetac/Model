package org.agetac.common.dto;

import java.util.Observer;

import org.agetac.common.observer.MyObservable;

public class AgentDTO implements IModel {

	private long id;
	private MyObservable observable = new MyObservable();
	
	public long getId() {
		return id;
	}


	@Override
	public PositionDTO getPosition() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setPosition(PositionDTO p) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addObserver(Observer obs) {
		observable.addObserver(obs);
	}
	
}
