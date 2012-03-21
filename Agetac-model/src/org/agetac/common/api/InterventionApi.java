package org.agetac.common.api;

import java.util.List;

import org.agetac.common.exception.BadResponseException;
import org.agetac.common.exception.InvalidJSONException;
import org.agetac.common.model.impl.Action;
import org.agetac.common.model.impl.Cible;
import org.agetac.common.model.impl.DemandeMoyen;
import org.agetac.common.model.impl.Implique;
import org.agetac.common.model.impl.Intervention;
import org.agetac.common.model.impl.Message;
import org.agetac.common.model.impl.Source;
import org.agetac.common.model.impl.Vehicule;

import org.json.JSONException;

public interface InterventionApi {

	public Message getMessage(String msgId) throws InvalidJSONException, BadResponseException;
	public List<Message> getMessages() throws BadResponseException;
	public Message putMessage(Message msg) throws JSONException, BadResponseException;
	public Message postMessage(Message msg) throws JSONException, BadResponseException;
	public void deleteMessage(Message msg) throws BadResponseException;
	

	public Vehicule getVehicule(String vId) throws InvalidJSONException, BadResponseException;
	public List<Vehicule> getVehicules() throws BadResponseException;
	public Vehicule putVehicule(Vehicule v) throws BadResponseException, JSONException;
	public Vehicule postVehicule(Vehicule v) throws JSONException, BadResponseException;
	public void deleteVehicule(Vehicule v) throws BadResponseException;

	public Source getSource(String sId) throws InvalidJSONException, BadResponseException;
	public List<Source> getSources() throws BadResponseException;
	public Source putSource(Source s) throws JSONException, BadResponseException;
	public Source postSource(Source s) throws JSONException, BadResponseException;
	public void deleteSource(Source s) throws BadResponseException;

	public Cible getCible(String cId) throws InvalidJSONException, BadResponseException;
	public List<Cible> getCibles() throws BadResponseException;
	public Cible putCible(Cible c) throws JSONException, BadResponseException;
	public Cible postCible(Cible c) throws JSONException, BadResponseException;
	public void deleteCible(Cible c) throws BadResponseException;
	
	public Action getAction(String aId) throws InvalidJSONException, BadResponseException;
	public List<Action> getActions() throws BadResponseException;
	public Action putAction(Action a) throws JSONException, BadResponseException;
	public Action postAction(Action c) throws JSONException, BadResponseException;
	public void deleteAction(Action a) throws BadResponseException;
	
	public Implique getImplique(String iId) throws InvalidJSONException, BadResponseException;
	public List<Implique> getImpliques() throws BadResponseException;
	public Implique putImplique(Implique i) throws JSONException, BadResponseException;
	public Implique postImplique(Implique c) throws JSONException, BadResponseException;
	public void deleteImplique(Implique a) throws BadResponseException;

	public DemandeMoyen getDemandeMoyen(String dId) throws InvalidJSONException, BadResponseException;
	public List<DemandeMoyen> getDemandesMoyen() throws BadResponseException;
	public DemandeMoyen putDemandeMoyen(DemandeMoyen d) throws JSONException, BadResponseException;
	public DemandeMoyen postDemandeMoyen(DemandeMoyen c) throws JSONException, BadResponseException;
	public void deleteDemandeMoyen(DemandeMoyen a) throws BadResponseException;
	
	public Intervention getIntervention() throws BadResponseException;
	
}
