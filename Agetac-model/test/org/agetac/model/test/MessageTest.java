package org.agetac.model.test;

import static org.junit.Assert.*;

import org.agetac.common.model.impl.Message;
import org.json.JSONException;
import org.junit.Test;

public class MessageTest {

	@Test
	public void jsonTransformNoException() throws Exception {
		Message m1 = new Message("m1", "Message de test", "1234");
		Message m2;
	
		m2 = new Message(m1.toJSON());
		m2.getMessage();
	}
	
	@Test
	public void jsonTransformEquality() {
		Message m1 = new Message("m1", "Message de test", "1234");
		Message m2 = null;
	
		try {
			m2 = new Message(m1.toJSON());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue((m1.getUniqueID() == m2.getUniqueID()) && (m1.getMessage() == m2.getMessage()));
	}

}
