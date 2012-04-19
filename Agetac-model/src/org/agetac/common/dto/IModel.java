package org.agetac.common.dto;

import java.util.Observer;

public interface IModel{

	public long getId();
	
	public PositionDTO getPosition();

	public void setPosition(PositionDTO p);
	
	public String getName();
	
	public void setName(String name);
	
	public void addObserver(Observer obs);
}
