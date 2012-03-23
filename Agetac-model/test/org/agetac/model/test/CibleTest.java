package org.agetac.model.test;

import static org.junit.Assert.*;

import org.agetac.common.exception.InvalidJSONException;
import org.agetac.common.model.impl.Cible;
import org.agetac.common.model.impl.Position;
import org.agetac.common.model.impl.Cible.CibleType;
import org.json.JSONException;
import org.junit.Test;

public class CibleTest {

	@Test
	public void jsonTransformNoException() throws Exception {
		Cible c1 = new Cible("c1", new Position(40.123,41.456), CibleType.WATER);
		Cible c2;
	
		c2 = new Cible(c1.toJSON());
		c2.getUniqueID();
	}
	
	@Test
	public void jsonTransformEquality() throws InvalidJSONException, JSONException {
		Cible c1 = new Cible("c1", new Position(40.123,41.456), CibleType.WATER);
		Cible c2;
	
		c2 = new Cible(c1.toJSON());

		assertTrue((c1.getUniqueID() == c2.getUniqueID()) && ((c1.getPosition().getLatitude() == c2.getPosition().getLatitude()) && (c1.getPosition().getLongitude() == c2.getPosition().getLongitude())));
	}
}
