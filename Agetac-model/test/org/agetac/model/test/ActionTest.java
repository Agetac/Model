package org.agetac.model.test;

import static org.junit.Assert.*;

import org.agetac.common.exception.InvalidJSONException;
import org.agetac.common.model.impl.Action;
import org.agetac.common.model.impl.Position;
import org.agetac.common.model.impl.Action.ActionType;
import org.json.JSONException;
import org.junit.Test;

public class ActionTest {

	@Test
	public void jsonTransformNoException() throws Exception {
		Action a1 = new Action("a1", new Position(40.123,41.456), ActionType.FIRE, new Position(40.123,41.456), new Position(40.123,41.456));
		Action a2;
	
		a2 = new Action(a1.toJSON());
		a2.getUniqueID();
	}
	
	@Test
	public void jsonTransformEquality() throws InvalidJSONException, JSONException {
		Action a1 = new Action("a1", new Position(40.123,41.456), ActionType.FIRE, new Position(40.123,41.456), new Position(40.123,41.456));
		Action a2;
	
		a2 = new Action(a1.toJSON());

		assertTrue((a1.getUniqueID() == a2.getUniqueID()) && ((a1.getPosition().getLatitude() == a2.getPosition().getLatitude()) && (a1.getPosition().getLongitude() == a2.getPosition().getLongitude())));
	}

}
