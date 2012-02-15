package org.agetac.model.test;

import static org.junit.Assert.*;

import org.agetac.model.impl.Groupe;
import org.agetac.model.impl.Position;
import org.agetac.model.impl.Vehicule;
import org.json.JSONException;
import org.junit.Test;

public class VehiculeTest {

	@Test
	public void jsonTransform() {
		Vehicule v1 = new Vehicule("v1","fpt", new Position(12.155466,42.5555), "Janzé", Vehicule.EtatVehicule.ALERTE, new Groupe(null,null, null));
		Vehicule v2 = null;
		try {
			v2 = new Vehicule(v1.toJSON());
		} catch (JSONException e) {
			System.out.println("test raté");
			fail("Exception lancé...");
		}
		assertTrue(v1.getUniqueID().equals(v2.getUniqueID()));
		assertTrue(v1.getEtat().equals(v2.getEtat()));
	}
	

}