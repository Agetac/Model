package org.agetac.model.test;

import static org.junit.Assert.assertTrue;

import org.agetac.common.exception.InvalidJSONException;
import org.agetac.common.model.impl.Position;
import org.agetac.common.model.impl.Source;
import org.agetac.common.model.impl.Source.SourceType;
import org.json.JSONException;
import org.junit.Test;

public class SourceTest {


	@Test
	public void jsonTransformNoException() throws Exception {
		Source s1 = new Source("s1", new Position(40.123,41.456), SourceType.WATER);
		Source s2;
	
		s2 = new Source(s1.toJSON());
		s2.getUniqueID();
	}
	
	@Test
	public void jsonTransformEquality() throws InvalidJSONException, JSONException {
		Source s1 = new Source("s1", new Position(40.123,41.456), SourceType.WATER);
		Source s2;
	
		s2 = new Source(s1.toJSON());

		assertTrue((s1.getUniqueID() == s2.getUniqueID()) && ((s1.getPosition().getLatitude() == s2.getPosition().getLatitude()) && (s1.getPosition().getLongitude() == s2.getPosition().getLongitude())));
	}
}
