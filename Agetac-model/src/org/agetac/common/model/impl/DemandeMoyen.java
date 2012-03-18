package org.agetac.common.model.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.agetac.common.model.impl.Vehicule.CategorieVehicule;
import org.agetac.common.model.sign.AbstractModel;

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
	
	public DemandeMoyen() {
		super("",new Position(0,0));
		this.etat = null;
		this.groupeID = "";
		this.groupesHoraires = new HashMap<EtatDemande, String>();
		this.categorie = null;
	}
	
	public DemandeMoyen(Position position, CategorieVehicule cat, EtatDemande etat, Groupe groupe, String heure) {
		super(cat.name()+"-demande", position);
		this.categorie = cat;
		this.etat = etat;
		this.groupeID = groupe.getUniqueID();
		this.groupesHoraires = new HashMap<EtatDemande, String>();
		this.groupesHoraires.put(EtatDemande.LANCEE, heure);
	}
	

	
	public DemandeMoyen(String nom, Position position, EtatDemande etat, String groupeID) {
		super(nom, position);
		this.etat = etat;
		this.groupeID = groupeID;
		this.groupesHoraires = new HashMap<EtatDemande, String>();
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
	public void setGroupe(String groupeID) {
		this.groupeID = groupeID;
	}
	public HashMap<EtatDemande, String> getGroupesHoraires() {
		return groupesHoraires;
	}

	public void setGroupesHoraires(HashMap<EtatDemande, String> groupesHoraires) {
		this.groupesHoraires = groupesHoraires;
	}
}
