package org.agetac.model.test;

import static org.junit.Assert.*;

import org.agetac.model.impl.Position;
import org.agetac.model.impl.Source;
import org.junit.Test;

public class SourceTest {


	@Test
	public void jsonTransformNoException() throws Exception {
		Source s1 = new Source("s1", new Position(40.123,41.456));
		Source s2;
	
		s2 = new Source(s1.toJSON());
		s2.getUniqueID();
	}
	
	@Test
	public void jsonTransformEquality() {
		Source s1 = new Source("s1", new Position(40.123,41.456));
		Source s2;
	
		s2 = new Source(s1.toJSON());

		assertTrue((s1.getUniqueID() == s2.getUniqueID()) && ((s1.getPosition().getLatitude() == s2.getPosition().getLatitude()) && (s1.getPosition().getLongitude() == s2.getPosition().getLongitude())));
	}
}
