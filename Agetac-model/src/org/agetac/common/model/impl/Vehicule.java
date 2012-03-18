package org.agetac.common.model.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

import org.agetac.common.model.sign.AbstractModel;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Vehicule extends AbstractModel {

	public enum EtatVehicule {
		DISPO_CASERNE, ALERTE, PARTIS, SUR_LES_LIEUX, TRANSPORT_HOPITAL, DISPO_RADIO, TEMPS_DEPASSE, DEMOBILISE
	}

	public enum CategorieVehicule {
		BEA, BRS, BLS, EMB, BLSP, CAEM, CCFM, CCGC, CCGCLC, DA, EPS, ESPM, FMOGP, FPT, MPR, PCM, PEVSD, SAC_PS, UTP, VPRO, VRCB, VICB, VAR, VL, VLCC, VLDP, VLCGD, VLCS, VLCG, VLHR, VLSV, VLOS, VLS, VNRBC, VPL, VPHV, VRAD, VSAV, VSM, VSR, VTP, VTU, VCYNO
	}

	private static final List<CategorieVehicule> VALUES_CategorieVehicule = Collections
			.unmodifiableList(Arrays.asList(CategorieVehicule.values()));
	private static final int SIZE_CategorieVehicule = VALUES_CategorieVehicule
			.size();

	private static final List<EtatVehicule> VALUES_EtatVehicule = Collections
			.unmodifiableList(Arrays.asList(EtatVehicule.values()));
	private static final int SIZE_EtatVehicule = VALUES_EtatVehicule.size();

	private Intervention intervention;
	
	private String caserneName;
	private EtatVehicule etat;
	private String groupeID;
	private HashMap<EtatVehicule, String> groupesHoraires;
	private CategorieVehicule categorie;

	public Vehicule(Position position, CategorieVehicule cat,
			String caserneName, EtatVehicule etat, Groupe groupe, String heure) {
		super(cat.name() + " " + caserneName, position);
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

	public Vehicule(String nom, Position position, String caserneName,
			EtatVehicule etat, String groupeID) {
		super(nom, position);
		this.caserneName = caserneName;
		this.etat = etat;
		this.groupeID = groupeID;
		this.groupesHoraires = new HashMap<EtatVehicule, String>();
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

	public void setGroupe(String groupeID) {
		this.groupeID = groupeID;
	}

	public HashMap<EtatVehicule, String> getGroupesHoraires() {
		return groupesHoraires;
	}

	public void setGroupesHoraires(HashMap<EtatVehicule, String> groupesHoraires) {
		this.groupesHoraires = groupesHoraires;
	}
}
