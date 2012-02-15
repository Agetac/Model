package org.agetac.model.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.agetac.model.impl.Agent;
import org.agetac.model.impl.Groupe;
import org.agetac.model.impl.Position;
import org.agetac.model.impl.Groupe;
import org.agetac.model.impl.Vehicule;
import org.json.JSONException;
import org.junit.Test;

public class GroupeTest {

	@Test
	public void jsonTransformNoException() throws Exception {
		

		List<Agent> subs = new ArrayList<Agent>();
		subs.add(new Agent("s1", "Sub1", Agent.Aptitude.CA, null));
		subs.add(new Agent("s2", "Sub2", Agent.Aptitude.CA, null));
		
		Agent chef = new Agent("c", "Chef", Agent.Aptitude.CDC, subs);
		
		
		List<Vehicule> vehicules = new ArrayList<Vehicule>();
		vehicules.add(new Vehicule("v1","fpt",new Position(40.1,41.0),"Janze", Vehicule.EtatVehicule.SUR_LES_LIEUX, "g"));
		
		Groupe g1 = new Groupe("g", new Agent("a", "bob", Agent.Aptitude.CDC, subs), null);
		Groupe g2 = null;
	
		g2 = new Groupe(g1.toJSON());
		
		assertTrue(g1.getUniqueID().equals(g2.getUniqueID()));
	}
	
	@Test
	public void jsonTransformEquality() {
		List<Agent> subs = new ArrayList<Agent>();
		subs.add(new Agent("s1", "Sub1", Agent.Aptitude.CA, null));
		subs.add(new Agent("s2", "Sub2", Agent.Aptitude.CA, null));
		
		Agent chef = new Agent("c", "Chef", Agent.Aptitude.CDC, subs);
		
		
		List<Vehicule> vehicules = new ArrayList<Vehicule>();
		vehicules.add(new Vehicule("v1","fpt",new Position(40.1,41.0),"Janze", Vehicule.EtatVehicule.SUR_LES_LIEUX, "g"));
		
		Groupe g1 = new Groupe("g", new Agent("a", "bob", Agent.Aptitude.CDC, subs), null);
		Groupe g2 = null;
	
		g2 = new Groupe(g1.toJSON());
		assertTrue(g1.getUniqueID().equals(g2.getUniqueID()));
		assertTrue(g1.getName().equals(g2.getName()));
	}
}
