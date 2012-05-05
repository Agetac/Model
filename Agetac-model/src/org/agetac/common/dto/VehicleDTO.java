package org.agetac.common.dto;

import java.util.Observer;

import org.agetac.common.observer.MyObservable;


public class VehicleDTO implements IModel {

	public enum VehicleState {
	    DISPO_CASERNE, ALERTE, PARTIS, SUR_LES_LIEUX, TRANSPORT_HOPITAL, DISPO_RADIO, TEMPS_DEPASSE, DEMOBILISE
	}
	
	public enum VehicleType {
		BEA, BRS, BLS, EMB, BLSP, CAEM, CCFM, CCGC, CCGCLC, DA,
		EPS, ESPM, FMOGP, FPT, MPR, PCM, PEVSD, SAC_PS, UTP, VPRO,
		VRCB, VICB, VAR, VL, VLCC, VLDP, VLCGD, VLCS, VLCG, VLHR,
		VLSV, VLOS, VLS, VNRBC, VPL, VPHV, VRAD, VSAV, VSM, VSR,
		VTP, VTU, VCYNO
	}
	
	private long id;
	private String name;
	private VehicleState state;
	private VehicleType type;
	private PositionDTO position;
	private BarrackDTO barrack;
	private GroupDTO group;
	
	private String arrivalTime, retTime, demandTime;
	
	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getRetTime() {
		return retTime;
	}

	public void setRetTime(String retTime) {
		this.retTime = retTime;
	}

	public String getDemandTime() {
		return demandTime;
	}

	public void setDemandTime(String demandTime) {
		this.demandTime = demandTime;
	}

	public MyObservable getObservable() {
		return observable;
	}

	public void setObservable(MyObservable observable) {
		this.observable = observable;
	}

	private MyObservable observable = new MyObservable();
	
	public VehicleDTO() {}
	
	public VehicleDTO(String n, VehicleState s, VehicleType t, PositionDTO p, BarrackDTO b) {
		this.name = n;
		this.state = s;
		this.type = t;
		this.position = p;
		this.barrack = b;
		observable.setChanged();
		observable.notifyObservers(this);
	}
	
	public VehicleDTO(PositionDTO p, VehicleType t, String barrack, VehicleState s, GroupDTO g, String string) {
		this.position = p;
		this.type = t;
		this.state = s;
		this.group = g;
		observable.setChanged();
		observable.notifyObservers(this);
	}

	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		observable.setChanged();
		observable.notifyObservers(this);
	}

	public VehicleState getState() {
		return state;
	}

	public void setState(VehicleState state) {
		this.state = state;
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

	public PositionDTO getPosition() {
		return position;
	}

	public void setPosition(PositionDTO position) {
		this.position = position;
		observable.setChanged();
		observable.notifyObservers(this);
	}

	public BarrackDTO getBarrack() {
		return barrack;
	}

	public void setBarrack(BarrackDTO barrack) {
		this.barrack = barrack;
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
