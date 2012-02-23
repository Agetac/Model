package org.agetac.model.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.agetac.model.exception.InvalidJSONException;
import org.agetac.model.impl.Action;
import org.agetac.model.impl.Cible;
import org.agetac.model.impl.Groupe;
import org.agetac.model.impl.Implique;
import org.agetac.model.impl.Intervention;
import org.agetac.model.impl.Message;
import org.agetac.model.impl.Position;
import org.agetac.model.impl.Source;
import org.agetac.model.impl.Vehicule;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class InterventionTest {


	@Test
	public void jsonTransformNoException() throws Exception {
		Vehicule v1 = new Vehicule("v1","fpt", new Position(12.155466,42.5555), "Janzé", Vehicule.EtatVehicule.ALERTE, new Groupe("g", null, null));
		Vehicule v2 = null;
	
		Intervention inter1 = new Intervention("inter");
		
		Position position = new Position(42.16545,42.65464);
		inter1.setPosition(position);
		
		
		List<Action> actions = new ArrayList<Action>();
		actions.add(new Action("act1", new Position(41.5454,42.5413)));
		actions.add(new Action("act2", new Position(41.5454,42.5413)));
		inter1.setActions(actions);
		
		List<Cible> cibles = new ArrayList<Cible>();
		cibles.add(new Cible("cib1", new Position(41.5454,42.5413)));
		cibles.add(new Cible("cib2", new Position(41.5454,42.5413)));
		inter1.setCibles(cibles);
		
		List<Source> sources = new ArrayList<Source>();
		sources.add(new Source("sou1", new Position(41.5454,42.5413)));
		sources.add(new Source("sou2", new Position(41.5454,42.5413)));
		inter1.setSources(sources);
		
		List<Implique> impliques = new ArrayList<Implique>();
		impliques.add(new Implique("imp1", Implique.EtatImplique.URGENCE_RELATIVE));
		impliques.add(new Implique("imp2", Implique.EtatImplique.INDEMNE));
		inter1.setImpliques(impliques);
		
		List<Message> messages = new ArrayList<Message>();
		messages.add(new Message("m1", "le message", "1145"));
		messages.add(new Message("m2", "le 2em message", "1146"));
		inter1.setMessages(messages);
		

		List<Vehicule> vehicules = new ArrayList<Vehicule>();
		Groupe g = new Groupe("g", null, null);
		vehicules.add(new Vehicule("v1","fpt", new Position(12.155466,42.5555), "Janzé", Vehicule.EtatVehicule.ALERTE, g));
		vehicules.add(new Vehicule("v2","fpt", new Position(12.155466,42.5556), "Janzé", Vehicule.EtatVehicule.ALERTE, g));
		inter1.setVehicules(vehicules);
		
		JSONObject jinter1 = inter1.toJSON();
		Intervention inter2 = new Intervention(jinter1);
		
		System.out.println(inter2);
		assertTrue(inter1.getUniqueID().equals(inter2.getUniqueID()));
	}
	
	@Test
	public void jsonTransformEquality() throws InvalidJSONException, JSONException {
		Vehicule v1 = new Vehicule("v1","fpt", new Position(12.155466,42.5555), "Janzé", Vehicule.EtatVehicule.ALERTE, new Groupe("g", null, null));
		Vehicule v2 = null;
	
		Intervention inter1 = new Intervention("inter");
		
		Position position = new Position(42.16545,42.65464);
		inter1.setPosition(position);
		
		
		List<Action> actions = new ArrayList<Action>();
		actions.add(new Action("act1", new Position(41.5454,42.5413)));
		actions.add(new Action("act2", new Position(41.5454,42.5413)));
		inter1.setActions(actions);
		
		List<Cible> cibles = new ArrayList<Cible>();
		cibles.add(new Cible("cib1", new Position(41.5454,42.5413)));
		cibles.add(new Cible("cib2", new Position(41.5454,42.5413)));
		inter1.setCibles(cibles);
		
		List<Source> sources = new ArrayList<Source>();
		sources.add(new Source("sou1", new Position(41.5454,42.5413)));
		sources.add(new Source("sou2", new Position(41.5454,42.5413)));
		inter1.setSources(sources);
		
		List<Implique> impliques = new ArrayList<Implique>();
		impliques.add(new Implique("imp1", Implique.EtatImplique.URGENCE_RELATIVE));
		impliques.add(new Implique("imp2", Implique.EtatImplique.INDEMNE));
		inter1.setImpliques(impliques);
		
		List<Message> messages = new ArrayList<Message>();
		messages.add(new Message("m1", "le message", "1145"));
		messages.add(new Message("m2", "le 2em message", "1146"));
		inter1.setMessages(messages);
		

		List<Vehicule> vehicules = new ArrayList<Vehicule>();
		Groupe g = new Groupe("g", null, null);
		vehicules.add(new Vehicule("v1","fpt", new Position(12.155466,42.5555), "Janzé", Vehicule.EtatVehicule.ALERTE, g));
		vehicules.add(new Vehicule("v2","fpt", new Position(12.155466,42.5556), "Janzé", Vehicule.EtatVehicule.ALERTE, g));
		inter1.setVehicules(vehicules);
		
		JSONObject jinter1 = inter1.toJSON();
		Intervention inter2 = new Intervention(jinter1);
		
		assertTrue(inter1.getUniqueID().equals(inter2.getUniqueID()));
		assertTrue(inter1.toString().equals(inter2.toString()));
	}
}
