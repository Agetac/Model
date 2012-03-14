package org.agetac.model.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.agetac.common.exception.InvalidJSONException;
import org.agetac.common.model.impl.Agent;
import org.json.JSONException;
import org.junit.Test;

public class AgentTest {

	@Test
	public void jsonTransformNoException() throws JSONException, InvalidJSONException {

		List<Agent> subs = new ArrayList<Agent>();
		subs.add(new Agent("s1", "Sub1", Agent.Aptitude.CA, null));
		subs.add(new Agent("s2", "Sub2", Agent.Aptitude.CA, null));
		Agent a1 = new Agent("a1", "Agent 1", Agent.Aptitude.CA, subs);
		Agent a2 = null;
		
		a2 = new Agent(a1.toJSON());
		
		assertTrue(a1.getUniqueID().equals(a2.getUniqueID()));
	}
	
	@Test
	public void jsonTransformEquality() throws JSONException, InvalidJSONException {
		
		List<Agent> subs = new ArrayList<Agent>();
		subs.add(new Agent("s1", "Sub1", Agent.Aptitude.CA, null));
		subs.add(new Agent("s2", "Sub2", Agent.Aptitude.CA, null));
		Agent a1 = new Agent("a1", "Agent 1", Agent.Aptitude.CA, subs);
		Agent a2 = null;
		
		a2 = new Agent(a1.toJSON());
		
		assertTrue(a1.getUniqueID().equals(a2.getUniqueID()));
		assertTrue(a1.getName().equals(a2.getName()));
		assertTrue(a1.getPosition().getLatitude() == a2.getPosition().getLatitude());
		assertTrue(a1.getPosition().getLongitude() == a2.getPosition().getLongitude());
		assertTrue(a2.getSubordonnes().size() == 2);
		assertTrue(a1.toJSON().toString().equals(a2.toJSON().toString()));
	}

}
