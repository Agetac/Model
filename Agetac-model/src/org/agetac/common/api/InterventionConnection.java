package org.agetac.common.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.agetac.common.exception.BadResponseException;
import org.agetac.common.exception.InvalidJSONException;
import org.agetac.common.model.impl.Action;
import org.agetac.common.model.impl.Cible;
import org.agetac.common.model.impl.Implique;
import org.agetac.common.model.impl.Message;
import org.agetac.common.model.impl.Source;
import org.agetac.common.model.impl.Vehicule;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class InterventionConnection implements InterventionApi {

	private String interId;
	private ServerApi serv;

	public InterventionConnection(String interId, ServerApi serv) {
		this.interId = interId;
		this.serv = serv;
	}

	public Message getMessage(String msgId) throws BadResponseException {
		Message m = null;

		Representation repr = serv.getResource("intervention/" + interId
				+ "/message", msgId);

		try {
			m = new Gson().fromJson(repr.getReader(), Message.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return m;
	}

	public List<Message> getMessages() throws BadResponseException {

		List<Message> messages = new ArrayList<Message>();

		// R�cup�ration de la liste des messages
		Representation repr = serv.getResource("intervention/" + interId
				+ "/message", null);

		try {

			messages = new Gson().fromJson(repr.getReader(),
					(Class<List<Message>>) (Class<?>) List.class);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return messages;
	}

	public Message putMessage(Message msg) throws BadResponseException {

		Representation r = new JsonRepresentation(new Gson().toJson(msg));
		r = serv.putResource("intervention/" + interId + "/message", null, r);

		try {
			return new Gson().fromJson(new JsonRepresentation(r).getReader(),
					Message.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void postMessage(Message msg) throws BadResponseException {

		Representation r = new JsonRepresentation(new Gson().toJson(msg));

		serv.postResource("intervention/" + interId + "/message",
				msg.getUniqueID(), r);

	}

	public void deleteMessage(Message msg) throws BadResponseException {
		serv.deleteResource("intervention/" + interId + "/message",
				msg.getUniqueID());
	}

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
			v = new Gson().fromJson(representation.getReader(), Vehicule.class);
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return v;
	}

	public List<Vehicule> getVehicules() throws BadResponseException {

		List<Vehicule> vehicules = new ArrayList<Vehicule>();
		JsonRepresentation representation = null;

		// R�cup�ration de la liste des Vehicules
		Representation repr = serv.getResource("intervention/" + interId
				+ "/vehicule", null);

		try {
			representation = new JsonRepresentation(repr);

			vehicules = new Gson().fromJson(repr.getReader(),
					(Class<List<Vehicule>>) (Class<?>) List.class);

		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}

		return vehicules;
	}

	public Vehicule putVehicule(Vehicule v) throws BadResponseException {

		Representation r = new JsonRepresentation(new Gson().toJson(v));

		r = serv.putResource("intervention/" + interId + "/vehicule", null, r);

		try {
			return new Gson().fromJson(new JsonRepresentation(r).getReader(),
					Vehicule.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void deleteVehicule(Vehicule v) throws BadResponseException {
		serv.deleteResource("intervention/" + interId + "/vehicule",
				v.getUniqueID());
	}

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
			s = new Gson().fromJson(representation.getReader(), Source.class);
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return s;
	}

	public Source putSource(Source s) throws BadResponseException {

		Representation r = new JsonRepresentation(new Gson().toJson(s));

		serv.putResource("intervention/" + interId + "/source", null, r);

		try {
			return new Gson().fromJson(new JsonRepresentation(r).getReader(),
					Source.class);
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public void deleteSource(Source s) throws BadResponseException {
		serv.deleteResource("intervention/" + interId + "/source",
				s.getUniqueID());
	}

	public List<Source> getSources() throws BadResponseException {

		List<Source> sources = new ArrayList<Source>();
		JsonRepresentation representation = null;

		// R�cup�ration de la liste des messages
		Representation repr = serv.getResource("intervention/" + interId
				+ "/source", null);

		try {
			representation = new JsonRepresentation(repr);

			sources = new Gson().fromJson(representation.getReader(),
					(Class<List<Source>>) (Class<?>) List.class);

		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}

		return sources;
	}

	public Cible getCible(String cId) throws InvalidJSONException,
			BadResponseException {
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
			c = new Gson().fromJson(representation.getReader(), Cible.class);
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}

	public Cible putCible(Cible c) throws BadResponseException {

		Representation r = new JsonRepresentation(new Gson().toJson(c));
		serv.putResource("intervention/" + interId + "/cible", null, r);

		try {
			return new Gson().fromJson(new JsonRepresentation(r).getReader(),
					Cible.class);
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public void deleteCible(Cible c) throws BadResponseException {
		serv.deleteResource("intervention/" + interId + "/cible",
				c.getUniqueID());
	}

	public Action getAction(String aId) throws InvalidJSONException,
			BadResponseException {
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
			a = new Gson().fromJson(representation.getReader(), Action.class);
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return a;
	}

	public Action putAction(Action a) throws BadResponseException {
		Representation r = new JsonRepresentation(new Gson().toJson(a));
		serv.putResource("intervention/" + interId + "/cible", null, r);

		try {
			return new Gson().fromJson(new JsonRepresentation(r).getReader(),
					Action.class);
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public void deleteAction(Action a) throws BadResponseException {
		serv.deleteResource("intervention/" + interId + "/cible",
				a.getUniqueID());
	}

	public Implique getImplique(String iId) throws BadResponseException,
			InvalidJSONException {
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
			i = new Gson().fromJson(representation.getReader(), Implique.class);
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	public Implique putImplique(Implique i) throws BadResponseException {
		Representation r = new JsonRepresentation(new Gson().toJson(i));
		serv.putResource("intervention/" + interId + "/implique", null, r);

		try {
			return new Gson().fromJson(new JsonRepresentation(r).getReader(),
					Implique.class);
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public void deleteImplique(Implique i) throws BadResponseException {
		serv.deleteResource("intervention/" + interId + "/implique",
				i.getUniqueID());
	}

	@Override
	public void postVehicule(Vehicule v) throws BadResponseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void postSource(Source s) throws BadResponseException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Cible> getCibles() throws BadResponseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void postCible(Cible c) throws BadResponseException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Action> getActions() throws BadResponseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void postAction(Action c) throws BadResponseException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Implique> getImpliques() throws BadResponseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void postImplique(Implique c) throws BadResponseException {
		// TODO Auto-generated method stub

	}
}
