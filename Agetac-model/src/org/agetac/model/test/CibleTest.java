package org.agetac.model.test;

import static org.junit.Assert.*;

import org.agetac.model.impl.Position;
import org.agetac.model.impl.Cible;
import org.junit.Test;

public class CibleTest {

	@Test
	public void jsonTransformNoException() throws Exception {
		Cible c1 = new Cible("c1", new Position(40.123,41.456));
		Cible c2;
	
		c2 = new Cible(c1.toJSON());
		c2.getUniqueID();
	}
	
	@Test
	public void jsonTransformEquality() {
		Cible c1 = new Cible("c1", new Position(40.123,41.456));
		Cible c2;
	
		c2 = new Cible(c1.toJSON());

		assertTrue((c1.getUniqueID() == c2.getUniqueID()) && ((c1.getPosition().getLatitude() == c2.getPosition().getLatitude()) && (c1.getPosition().getLongitude() == c2.getPosition().getLongitude())));
	}
}
