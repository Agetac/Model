package org.agetac.model.test;

import static org.junit.Assert.*;

import org.agetac.common.exception.InvalidJSONException;
import org.agetac.common.model.impl.Implique;
import org.json.JSONException;
import org.junit.Test;

public class ImpliqueTest {


	@Test
	public void jsonTransformNoException() throws Exception {
		Implique i1 = new Implique("i1", Implique.EtatImplique.URGENCE_ABSOLUE);
		Implique i2;
	
		i2 = new Implique(i1.toJSON());
		i2.getEtat();
	}
	
	@Test
	public void jsonTransformEquality() throws InvalidJSONException, JSONException {
		Implique i1 = new Implique("i1", Implique.EtatImplique.URGENCE_ABSOLUE);
		Implique i2;
	
		i2 = new Implique(i1.toJSON());

		assertTrue((i1.getUniqueID() == i2.getUniqueID()) && (i1.getEtat() == i2.getEtat()));
	}
}
