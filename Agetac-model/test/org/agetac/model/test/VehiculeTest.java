package org.agetac.model.test;

import static org.junit.Assert.*;

import org.agetac.common.exception.InvalidJSONException;
import org.agetac.common.model.impl.Groupe;
import org.agetac.common.model.impl.Position;
import org.agetac.common.model.impl.Vehicule;
import org.agetac.common.model.impl.Vehicule.CategorieVehicule;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class VehiculeTest {

	@Test
	public void jsonTransformNoException() throws Exception {
		Vehicule v1 = new Vehicule("v1","Janze", new Position(12.155466,42.5555), CategorieVehicule.FPT, "Janzé", Vehicule.EtatVehicule.ALERTE, new Groupe("g", null, null), "4242");
		Vehicule v2 = null;
	
		JSONObject jv1 = v1.toJSON();
		v2 = new Vehicule(jv1);
		
		assertTrue(v1.getUniqueID().equals(v2.getUniqueID()));
	}
	
	@Test
	public void jsonTransformEquality() throws InvalidJSONException, JSONException {
		Vehicule v1 = new Vehicule("v1","Janze", new Position(12.155466,42.5555), CategorieVehicule.FPT, "Janzé", Vehicule.EtatVehicule.ALERTE, new Groupe("g", null, null), "1664");
		Vehicule v2 = null;
	
		
		v2 = new Vehicule(v1.toJSON());


		assertTrue(v1.getUniqueID().equals(v2.getUniqueID()));
		assertTrue(v1.getEtat().equals(v2.getEtat()));
	}
	
}
