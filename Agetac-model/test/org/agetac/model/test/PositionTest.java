package org.agetac.model.test;

import static org.junit.Assert.*;

import org.agetac.common.exception.InvalidJSONException;
import org.agetac.common.model.impl.Position;
import org.json.JSONException;
import org.junit.Test;

public class PositionTest {

	@Test
	public void jsonTransformNoException() throws Exception {
		Position p1 = new Position(42.123, 45.456);
		Position p2;
	
		p2 = new Position(p1.toJSON());
		p2.getLatitude();
	}
	
	@Test
	public void jsonTransformEquality() throws InvalidJSONException, JSONException {
		Position p1 = new Position(42.123, 45.456);
		Position p2 = null;
	
		p2 = new Position(p1.toJSON());

		assertTrue((p1.getLatitude() == p2.getLatitude()) && p1.getLongitude() == p2.getLongitude());
	}
}
