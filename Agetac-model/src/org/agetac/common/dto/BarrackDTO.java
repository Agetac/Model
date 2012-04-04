package org.agetac.common.dto;

public class BarrackDTO implements IModel {

	private long id;
	private String name;
	private PositionDTO position;
	
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
	
}
