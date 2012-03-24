package org.agetac.common.model.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.agetac.common.exception.InvalidJSONException;
import org.agetac.common.model.sign.AbstractModel;
import org.json.JSONException;
import org.json.JSONObject;


public class Vehicule extends AbstractModel {

	public enum EtatVehicule {
	    DISPO_CASERNE, ALERTE, PARTIS, SUR_LES_LIEUX, TRANSPORT_HOPITAL, DISPO_RADIO, TEMPS_DEPASSE, DEMOBILISE
	}
	
	public enum CategorieVehicule {
		BEA, BRS, BLS, EMB, BLSP, CAEM, CCFM, CCGC, CCGCLC, DA,
		EPS, ESPM, FMOGP, FPT, MPR, PCM, PEVSD, SAC_PS, UTP, VPRO,
		VRCB, VICB, VAR, VL, VLCC, VLDP, VLCGD, VLCS, VLCG, VLHR,
		VLSV, VLOS, VLS, VNRBC, VPL, VPHV, VRAD, VSAV, VSM, VSR,
		VTP, VTU, VCYNO
	}
	
	private static final List<CategorieVehicule> VALUES_CategorieVehicule = Collections.unmodifiableList(Arrays.asList(CategorieVehicule.values()));
	private static final int SIZE_CategorieVehicule = VALUES_CategorieVehicule.size();
	
	private static final List<EtatVehicule> VALUES_EtatVehicule = Collections.unmodifiableList(Arrays.asList(EtatVehicule.values()));
	private static final int SIZE_EtatVehicule = VALUES_EtatVehicule.size();
	
	private String caserneName;
	private EtatVehicule etat;
	private String groupeID;
	private HashMap<EtatVehicule, String> groupesHoraires; 
	private CategorieVehicule categorie;
	
	public Vehicule() {
		super(null, null, new Position(0, 0));
	}
	
	public Vehicule(String uid, Position position, CategorieVehicule cat, String caserneName, EtatVehicule etat, Groupe groupe, String heure) {
		super(uid, cat.name()+" "+caserneName, position);
		this.categorie = cat;
		this.caserneName = caserneName;
		this.etat = etat;
		this.groupeID = groupe.getUniqueID();
		this.groupesHoraires = new HashMap<EtatVehicule, String>();
		this.groupesHoraires.put(EtatVehicule.DISPO_CASERNE, heure);
		this.groupesHoraires.put(EtatVehicule.ALERTE, heure);
		this.groupesHoraires.put(EtatVehicule.PARTIS, heure);
		this.groupesHoraires.put(EtatVehicule.SUR_LES_LIEUX, "");
		this.groupesHoraires.put(EtatVehicule.TRANSPORT_HOPITAL, "");
		this.groupesHoraires.put(EtatVehicule.DISPO_RADIO, "");
		this.groupesHoraires.put(EtatVehicule.TEMPS_DEPASSE, "");
		this.groupesHoraires.put(EtatVehicule.DEMOBILISE, "");
	}
	
	public Vehicule(String uid, Position position, CategorieVehicule cat, String caserneName, EtatVehicule etat, String groupeUID, String heure) {
		super(uid, cat.name()+" "+caserneName, position);
		this.categorie = cat;
		this.caserneName = caserneName;
		this.etat = etat;
		this.groupeID = groupeUID;
		this.groupesHoraires = new HashMap<EtatVehicule, String>();
		this.groupesHoraires.put(EtatVehicule.DISPO_CASERNE, heure);
		this.groupesHoraires.put(EtatVehicule.ALERTE, heure);
		this.groupesHoraires.put(EtatVehicule.PARTIS, heure);
		this.groupesHoraires.put(EtatVehicule.SUR_LES_LIEUX, "");
		this.groupesHoraires.put(EtatVehicule.TRANSPORT_HOPITAL, "");
		this.groupesHoraires.put(EtatVehicule.DISPO_RADIO, "");
		this.groupesHoraires.put(EtatVehicule.TEMPS_DEPASSE, "");
		this.groupesHoraires.put(EtatVehicule.DEMOBILISE, "");
	}
	

	
	public Vehicule(String uid, String nom, Position position, String caserneName, EtatVehicule etat, String groupeID) {
		super(uid, nom, position);
		this.caserneName = caserneName;
		this.etat = etat;
		this.groupeID = groupeID;
		this.groupesHoraires = new HashMap<EtatVehicule, String>();
	}
	
	public Vehicule(JSONObject json) throws InvalidJSONException {
		super(json);
		try {
			this.categorie = CategorieVehicule.valueOf(json.getString("categorie"));
			this.etat = EtatVehicule.valueOf(json.getString("etat"));
			this.groupeID = json.getString("groupeID");
			this.caserneName = json.getString("caserneName");
			//TODO: Compléter avec la liste des groupe horaire
		} catch(JSONException e){
			throw new InvalidJSONException(json.toString());
		}
	}
	
	/**
	 * Convert this object to a JSON object for representation
	 * @throws JSONException 
	 */
	public JSONObject toJSON() throws JSONException {
		JSONObject json = super.toJSON();

		json.put("etat", this.etat.name());
		json.put("groupeID", this.groupeID);
		json.put("categorie", this.categorie.name());
		json.put("caserneName", this.caserneName);
		//TODO: Compléter avec la liste des groupe horaire
		return json;
	}
	
	public String getCaserneName() {
		return caserneName;
	}
	
	public void setCaserneName(String caserneName) {
		this.caserneName = caserneName;
	}

	public EtatVehicule getEtat() {
		return etat;
	}
	
	public CategorieVehicule getCategorie() {
		return categorie;
	}
	
	public void setCategorie(CategorieVehicule cat) {
		this.categorie = cat;
	}

	public void setEtat(EtatVehicule etat) {
		this.etat = etat;
	}

	public String getGroupe() {
		return groupeID;
	}

	public void setGroupe(Groupe groupe) {
		this.groupeID = groupe.getUniqueID();
	}
	
	public void setGroupeID(String groupeID) {
		this.groupeID = groupeID;
	}

	public HashMap<EtatVehicule, String> getGroupesHoraires() {
		return groupesHoraires;
	}

	public void setGroupesHoraires(HashMap<EtatVehicule, String> groupesHoraires) {
		this.groupesHoraires = groupesHoraires;
	}

	/**
	 * Convert this object to a string for representation
	 */
	public String toString() {
		try {
			return this.toJSON().toString();
		} catch (JSONException e) {
			return "Error";
		}
	}
}
