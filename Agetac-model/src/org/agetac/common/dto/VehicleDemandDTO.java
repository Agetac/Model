package org.agetac.common.dto;

import java.util.Date;
import java.util.Observer;

import org.agetac.common.dto.VehicleDTO.VehicleType;
import org.agetac.common.observer.MyObservable;

public class VehicleDemandDTO implements IModel {

	public enum DemandState {ASKED, REFUSED, ACCEPTED}
	
	private long id;
	private Date groupeHoraire;
	private DemandState state;
	private PositionDTO position;
	private VehicleType type;
	private String name;
	private GroupDTO group;

	/** default vehicle id associated with the demand is unknown (-1)*/
	private int vehicleId = -1;
	
	private MyObservable observable = new MyObservable();
	
	public VehicleDemandDTO() {}
	
	public VehicleDemandDTO(DemandState s, VehicleType t, PositionDTO p, Date date) {
		this.state = s;
		this.type = t;
		this.position = p;
		this.groupeHoraire = date;
	}
	
	public VehicleDemandDTO(String n, PositionDTO p, DemandState s, GroupDTO g) {
		this.name = n;
		this.position = p;
		this.state = s;
		this.group = g;
		observable.setChanged();
		observable.notifyObservers(this);
	}

	public long getId() {
		return id;
	}
	
	public Date getGroupeHoraire() {
		return groupeHoraire;
	}

	public void setGroupeHoraire(Date groupeHoraire) {
		this.groupeHoraire = groupeHoraire;
		observable.setChanged();
		observable.notifyObservers(this);
	}

	public DemandState getState() {
		return state;
	}

	public void setState(DemandState state) {
		this.state = state;
		observable.setChanged();
		observable.notifyObservers(this);
	}

	public PositionDTO getPosition() {
		return position;
	}

	public void setPosition(PositionDTO position) {
		this.position = position;
		observable.setChanged();
		observable.notifyObservers(this);
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
		observable.setChanged();
		observable.notifyObservers(this);
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
		observable.setChanged();
		observable.notifyObservers(this);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
		observable.setChanged();
		observable.notifyObservers(this);
	}

	public GroupDTO getGroup() {
		return group;
	}

	public void setGroup(GroupDTO group) {
		this.group = group;
		observable.setChanged();
		observable.notifyObservers(this);
	}

	public void setId(long id) {
		this.id = id;
		observable.setChanged();
		observable.notifyObservers(this);
	}

	@Override
	public void addObserver(Observer obs) {
		observable.addObserver(obs);
	}
}
