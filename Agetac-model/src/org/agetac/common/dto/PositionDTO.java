package org.agetac.common.dto;

public class PositionDTO {

	private long id;
	private int latitude;
	private int longitude;
	private boolean isKnown = false;
	
	public PositionDTO() {}
	
	public PositionDTO(int latitude, int longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public PositionDTO(PositionDTO p) {
		if (p != null) {
			this.latitude = p.getLatitude();
			this.longitude = p.getLongitude();
		}
	}

	public long getId() {
		return id;
	}
	
	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public boolean isKnown() {
		return isKnown;
	}

	public void setKnown(boolean isKnown) {
		this.isKnown = isKnown;
	}
	
	@Override
	public String toString() {
		return "("+latitude + ", "+longitude+")";
	}
}
