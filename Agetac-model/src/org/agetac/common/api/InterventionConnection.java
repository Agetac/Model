package org.agetac.common.api;

import java.io.IOException;
import java.util.ArrayList;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;

public class InterventionConnection implements InterventionApi {

	private String interId;
	private ServerApi serv;

	public InterventionConnection(String interId, ServerApi serv) {
		this.interId = interId;
		this.serv = serv;
	}
	
	@Override
	public Intervention getIntervention() throws BadResponseException {
		Intervention i = null;
		JsonRepresentation representation = null;

		Representation repr = serv.getResource("intervention", interId);

		try {
			representation = new JsonRepresentation(repr);
			i = new Intervention(representation.getJsonObject());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (InvalidJSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}
	
	
	
	
	
	@Override
	public Message getMessage(String msgId) throws BadResponseException {
		Message m = null;
		JsonRepresentation representation = null;

		Representation repr = serv.getResource("intervention/" + interId
				+ "/message", msgId);

		try {
			representation = new JsonRepresentation(repr);
			m = new Message(representation.getJsonObject());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return m;
	}
	@Override
	public List<Message> getMessages() throws BadResponseException {

		List<Message> messages = new ArrayList<Message>();
		JsonRepresentation representation = null;

		// R�cup�ration de la liste des messages
		Representation repr = serv.getResource("intervention/" + interId + "/message", null);

		try {
			representation = new JsonRepresentation(repr);
			JSONArray ar = representation.getJsonArray(); 
			for (int i = 0; i < ar.length(); i++) {
				messages.add(new Message(ar.getJSONObject(i)));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return messages;
	}
	@Override
	public Message putMessage(Message msg) throws JSONException, BadResponseException {

		Representation r = new JsonRepresentation(msg.toJSON());
		r = serv.putResource("intervention/" + interId + "/message", null, r);
		Message message = null;
		try {
			message = new Message(new JsonRepresentation(r).getJsonObject());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return message;
	}
	@Override
	public Message postMessage(Message msg) throws JSONException, BadResponseException {

		Representation r = new JsonRepresentation(msg.toJSON());

		r = serv.postResource("intervention/" + interId + "/message", msg.getUniqueID(), r);
		Message message = null;
		try {
			 message =  new Message(new JsonRepresentation(r).getJsonObject());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  message;

	}
	@Override
	public void deleteMessage(Message msg) throws BadResponseException {
		serv.deleteResource("intervention/" + interId + "/message",	msg.getUniqueID());
	}
	
	@Override
	public Vehicule getVehicule(String vId) throws BadResponseException {
		Vehicule v = null;
		JsonRepresentation representation = null;

		Representation repr = serv.getResource("intervention/" + interId
				+ "/vehicule", vId);

		try {
			representation = new JsonRepresentation(repr);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			v = new Vehicule(representation.getJsonObject());
		} catch (InvalidJSONException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return v;
	}
	@Override
	public List<Vehicule> getVehicules() throws BadResponseException {

		List<Vehicule> vehicules = new ArrayList<Vehicule>();
		JsonRepresentation representation = null;

		// R�cup�ration de la liste des Vehicules
		Representation repr = serv.getResource("intervention/" + interId
				+ "/vehicule", null);

		try {
			representation = new JsonRepresentation(repr);
			JSONArray ar = representation.getJsonArray(); 
			for (int i = 0; i < ar.length(); i++) {
				vehicules.add(new Vehicule(ar.getJSONObject(i)));
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}

		return vehicules;
	}
	@Override
	public Vehicule putVehicule(Vehicule v) throws BadResponseException, JSONException {

		Representation r = new JsonRepresentation(v.toJSON());

		r = serv.putResource("intervention/" + interId + "/vehicule", null, r);
		Vehicule vehicule = null;
		try {
			vehicule = new Vehicule(new JsonRepresentation(r).getJsonObject());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidJSONException e) {
			e.printStackTrace();
		}

		return null;
	}
	@Override
	public void deleteVehicule(Vehicule v) throws BadResponseException {
		serv.deleteResource("intervention/" + interId + "/vehicule",
				v.getUniqueID());
	}
	@Override
	public Vehicule postVehicule(Vehicule v) throws JSONException,BadResponseException {
		Representation r = new JsonRepresentation(v.toJSON());

		r = serv.postResource("intervention/" + interId + "/vehicule", v.getUniqueID(), r);
		Vehicule vehicule = null;
		try {
			vehicule = new Vehicule(new JsonRepresentation(r).getJsonObject());
		} catch (InvalidJSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return vehicule;

	}
	
	@Override
	public DemandeMoyen getDemandeMoyen(String dId)	throws BadResponseException {
		DemandeMoyen d = null;
		JsonRepresentation representation = null;

		Representation repr = serv.getResource("intervention/" + interId
				+ "/demande", dId);

		try {
			representation = new JsonRepresentation(repr);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			d = new DemandeMoyen(representation.getJsonObject());
		} catch (InvalidJSONException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return d;
	}
	@Override
	public List<DemandeMoyen> getDemandesMoyen() throws BadResponseException {
		List<DemandeMoyen> demandes = new ArrayList<DemandeMoyen>();
		JsonRepresentation representation = null;

		// R�cup�ration de la liste des demandes
		Representation repr = serv.getResource("intervention/" + interId
				+ "/demande", null);

		try {
			representation = new JsonRepresentation(repr);
			JSONArray ar = representation.getJsonArray();
			for (int i = 0; i < ar.length(); i++) {
				demandes.add(new DemandeMoyen(ar.getJSONObject(i)));
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}

		return demandes;
	}
	@Override
	public DemandeMoyen postDemandeMoyen(DemandeMoyen dem) throws JSONException,
			BadResponseException {
		
		Representation r = new JsonRepresentation(dem.toJSON());

		r = serv.postResource("intervention/" + interId + "/demande", dem.getUniqueID(), r);
		DemandeMoyen demande = null;
		try {
			demande = new DemandeMoyen(new JsonRepresentation(r).getJsonObject());
		} catch (InvalidJSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return demande;
	}
@Override
	public DemandeMoyen putDemandeMoyen(DemandeMoyen dm)
			throws BadResponseException, JSONException {

		Representation r = new JsonRepresentation(dm.toJSON());

		r = serv.putResource("intervention/" + interId + "/demande", null, r);
		DemandeMoyen demande = null;
		try {
			demande = new DemandeMoyen(new JsonRepresentation(r).getJsonObject());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidJSONException e) {
			e.printStackTrace();
		}

		return demande;
	}
@Override
	public void deleteDemandeMoyen(DemandeMoyen dm) throws BadResponseException {
		serv.deleteResource("intervention/" + interId + "/demande",
				dm.getUniqueID());
	}

	@Override
	public Source getSource(String sId) throws BadResponseException {
		Source s = null;
		JsonRepresentation representation = null;

		Representation repr = serv.getResource("intervention/" + interId
				+ "/source", sId);

		try {
			representation = new JsonRepresentation(repr);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			s = new Source(representation.getJsonObject());
		} catch (InvalidJSONException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return s;
	}
	@Override
	public Source putSource(Source s) throws JSONException,
			BadResponseException {

		Representation r = new JsonRepresentation(s.toJSON());

		r= serv.putResource("intervention/" + interId + "/source", null, r);
		Source source = null;
		try {
			source= new Source(new JsonRepresentation(r).getJsonObject());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidJSONException e) {
			e.printStackTrace();
		}
		return source;

	}
	@Override
	public void deleteSource(Source s) throws BadResponseException {
		serv.deleteResource("intervention/" + interId + "/source",
				s.getUniqueID());
	}
	@Override
	public List<Source> getSources() throws BadResponseException {

		List<Source> sources = new ArrayList<Source>();
		JsonRepresentation representation = null;

		// R�cup�ration de la liste des messages
		Representation repr = serv.getResource("intervention/" + interId
				+ "/source", null);

		try {
			representation = new JsonRepresentation(repr);
			JSONArray ar = representation.getJsonArray(); 
			for (int i = 0; i < ar.length(); i++) {
				Source src = new Source(ar.getJSONObject(i));
				sources.add(src);
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}

		return sources;
	}
	@Override
	public Source postSource(Source s) throws JSONException, BadResponseException {
		Representation r = new JsonRepresentation(s.toJSON());

		r = serv.postResource("intervention/" + interId + "/source", s.getUniqueID(), r);
		Source source = null;
		try {
			source = new Source(new JsonRepresentation(r).getJsonObject());
		} catch (InvalidJSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return source;

	}
	
	@Override
	public Cible getCible(String cId) throws InvalidJSONException, BadResponseException {
		Cible c = null;
		JsonRepresentation representation = null;

		Representation repr = serv.getResource("intervention/" + interId
				+ "/cible", cId);

		try {
			representation = new JsonRepresentation(repr);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			c = new Cible(representation.getJsonObject());
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return c;
	}
	@Override
	public Cible putCible(Cible c) throws JSONException, BadResponseException {

		Representation r = new JsonRepresentation(c.toJSON());
		r = serv.putResource("intervention/" + interId + "/cible", null, r);
		Cible cible = null;
		try {
			cible = new Cible(new JsonRepresentation(r).getJsonObject());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidJSONException e) {
			e.printStackTrace();
		}
		return cible;

	}
	@Override
	public void deleteCible(Cible c) throws BadResponseException {
		serv.deleteResource("intervention/" + interId + "/cible",
				c.getUniqueID());
	}
	@Override
	public List<Cible> getCibles() throws BadResponseException {

		List<Cible> cibles = new ArrayList<Cible>();
		JsonRepresentation representation = null;

		// R�cup�ration de la liste des messages
		Representation repr = serv.getResource("intervention/" + interId + "/cible", null);

		try {
			representation = new JsonRepresentation(repr);
			JSONArray ar = representation.getJsonArray(); 
			for (int i = 0; i < ar.length(); i++) {
				cibles.add(new Cible(ar.getJSONObject(i)));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (InvalidJSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cibles;
	}
	@Override
	public Cible postCible(Cible c) throws JSONException, BadResponseException {
		
		Representation r = new JsonRepresentation(c.toJSON());
		r = serv.postResource("intervention/" + interId + "/cible", c.getUniqueID(), r);
		Cible cible = null;
		try {
			cible = new Cible(new JsonRepresentation(r).getJsonObject());
		} catch (InvalidJSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cible;
	}

	@Override
	public Action getAction(String aId) throws InvalidJSONException, BadResponseException {
		Action a = null;
		JsonRepresentation representation = null;

		Representation repr = serv.getResource("intervention/" + interId
				+ "/action", aId);

		try {
			representation = new JsonRepresentation(repr);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			a = new Action(representation.getJsonObject());
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return a;
	}
	@Override
	public Action putAction(Action a) throws JSONException,	BadResponseException {
		
		Representation r = new JsonRepresentation(a.toJSON());
		
		r = serv.putResource("intervention/" + interId + "/action", null, r);
		Action action = null;
		try {
			action= new Action(new JsonRepresentation(r).getJsonObject());
		} catch (InvalidJSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return action;
	}
	@Override
	public void deleteAction(Action a) throws BadResponseException {
		serv.deleteResource("intervention/" + interId + "/cible",
				a.getUniqueID());
	}
	@Override
	public List<Action> getActions() throws BadResponseException {
		List<Action> actions = new ArrayList<Action>();
		JsonRepresentation representation = null;

		// R�cup�ration de la liste des messages
		Representation repr = serv.getResource("intervention/" + interId + "/action", null);

		try {
			representation = new JsonRepresentation(repr);
			JSONArray ar = representation.getJsonArray(); 
		
			for (int i = 0; i < ar.length(); i++) {
				actions.add(new Action(ar.getJSONObject(i)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (InvalidJSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return actions;
	}
	@Override
	public Action postAction(Action a) throws JSONException, BadResponseException {
		
		Representation r = new JsonRepresentation(a.toJSON());
		r = serv.postResource("intervention/" + interId + "/action", a.getUniqueID(), r);
		Action action = null;
		try {
			action =  new Action(new JsonRepresentation(r).getJsonObject());
		} catch (InvalidJSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return action;
	}

	@Override
	public Implique getImplique(String iId) throws BadResponseException, InvalidJSONException {
		Implique i = null;
		JsonRepresentation representation = null;

		Representation repr = serv.getResource("intervention/" + interId
				+ "/implique", iId);

		try {
			representation = new JsonRepresentation(repr);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			i = new Implique(representation.getJsonObject());
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return i;
	}
	@Override
	public Implique putImplique(Implique i) throws JSONException, BadResponseException {
		Representation r = new JsonRepresentation(i.toJSON());
		r = serv.putResource("intervention/" + interId + "/implique", null, r);
		Implique implique = null;
		try {
			implique = new Implique(new JsonRepresentation(r).getJsonObject());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidJSONException e) {
			e.printStackTrace();
		}
		return implique;
	}
	@Override
	public void deleteImplique(Implique i) throws BadResponseException {
		serv.deleteResource("intervention/" + interId + "/implique",
				i.getUniqueID());
	}
	@Override
	public List<Implique> getImpliques() throws BadResponseException {
		List<Implique> impliques = new ArrayList<Implique>();
		JsonRepresentation representation = null;

		// R�cup�ration de la liste des messages
		Representation repr = serv.getResource("intervention/" + interId + "/implique", null);

		try {
			representation = new JsonRepresentation(repr);
			JSONArray ar = representation.getJsonArray(); 
		
			for (int i = 0; i < ar.length(); i++) {
				impliques.add(new Implique(ar.getJSONObject(i)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (InvalidJSONException e) {
			e.printStackTrace();
		}

		return impliques;
	}
	@Override
	public Implique postImplique(Implique i) throws JSONException,	BadResponseException {
		Representation r = new JsonRepresentation(i.toJSON());

		r = serv.postResource("intervention/" + interId + "/implique", i.getUniqueID(), r);
		Implique implique = null;
		try {
			implique = new Implique(new JsonRepresentation(r).getJsonObject());
		} catch (InvalidJSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return implique;

	}


}
