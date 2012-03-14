package org.agetac.common.model.sign;

import org.json.JSONException;
import org.json.JSONObject;

public interface IJsonable {
	public JSONObject toJSON() throws JSONException;
}
