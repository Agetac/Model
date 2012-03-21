package org.agetac.common.model.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.agetac.common.exception.InvalidJSONException;
import org.agetac.common.model.impl.Vehicule.CategorieVehicule;
import org.agetac.common.model.sign.AbstractModel;
import org.json.JSONException;
import org.json.JSONObject;

public class DemandeMoyen extends AbstractModel {

	public enum EtatDemande {
	 LANCEE, REFUSEE, ACCEPTEE
	}
	
	private static final List<CategorieVehicule> VALUES_CategorieVehicule = Collections.unmodifiableList(Arrays.asList(CategorieVehicule.values()));
	private static final int SIZE_CategorieVehicule = VALUES_CategorieVehicule.size();
	
	private static final List<EtatDemande> VALUES_EtatDemande = Collections.unmodifiableList(Arrays.asList(EtatDemande.values()));
	private static final int SIZE_EtatDemande = VALUES_EtatDemande.size();
	
	private EtatDemande etat;
	private String groupeID;
	private HashMap<EtatDemande, String> groupesHoraires; 
	private CategorieVehicule categorie;
	
	private String vehId = null; // l'id du vehicule r�sultat de la demande
	
	public String getVehId() {
		return vehId;
	}

	public void setVehId(String vehId) {
		this.vehId = vehId;
	}

	public DemandeMoyen() {
		super("42","demande",new Position(0,0));
		this.etat = null;
		this.groupeID = "";
		this.groupesHoraires = new HashMap<EtatDemande, String>();
		this.categorie = null;
		this.vehId = null;
	}
	
	public DemandeMoyen(String uid, Position position, CategorieVehicule cat, EtatDemande etat, Groupe groupe, String heure) {
		super(uid, cat.name()+"-demande", position);
		this.categorie = cat;
		this.etat = etat;
		this.groupeID = groupe.getUniqueID();
		this.groupesHoraires = new HashMap<EtatDemande, String>();
		this.groupesHoraires.put(EtatDemande.LANCEE, heure);
		this.vehId = null;
	}
	

	
	public DemandeMoyen(String uid, String nom, Position position, EtatDemande etat, String groupeID) {
		super(uid, nom, position);
		this.etat = etat;
		this.groupeID = groupeID;
		this.groupesHoraires = new HashMap<EtatDemande, String>();
		this.vehId = null;
	}
	
	public DemandeMoyen(JSONObject json) throws InvalidJSONException {
		super(json);
		try{
			this.categorie = CategorieVehicule.valueOf(json.getString("categorie"));
			this.etat = EtatDemande.valueOf(json.getString("etat"));
			this.groupeID = json.getString("groupeID");
			//TODO: Compléter avec la liste des groupe horaire
			this.vehId = json.getString("vehId");
			this.groupesHoraires = new HashMap<EtatDemande, String>();
		}catch(JSONException e){
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
		json.put("vehId", this.vehId);
		json.put("categorie", this.categorie.name());
		//TODO: Compléter avec la liste des groupe horaire
		return json;
	}
	


	public EtatDemande getEtat() {
		return etat;
	}
	
	public CategorieVehicule getCategorie() {
		return categorie;
	}
	
	public void setCategorie(CategorieVehicule cat) {
		this.categorie = cat;
	}

	public void setEtat(EtatDemande etat) {
		
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
	public HashMap<EtatDemande, String> getGroupesHoraires() {
		return groupesHoraires;
	}

	public void setGroupesHoraires(HashMap<EtatDemande, String> groupesHoraires) {
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
