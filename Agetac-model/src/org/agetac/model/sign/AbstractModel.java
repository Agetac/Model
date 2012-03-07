package org.agetac.model.sign;

import javax.jdo.annotations.PersistenceCapable;

import org.agetac.model.exception.InvalidJSONException;
import org.agetac.model.impl.Position;
import org.json.JSONException;
import org.json.JSONObject;

@PersistenceCapable
public abstract class AbstractModel implements IJsonable, IModel {

	protected String uniqueID;
	protected String name;
	protected Position position;

	public AbstractModel(String name, Position position){
		if (name == null) {
			name = "";
		}
		if (position == null) {
			position = new Position(0, 0);
		}
		
		this.name = name;
		this.position = position;
	}
	
	public AbstractModel(String uid, String name, Position position) {
		this(name, position);
		if (uid == null) {
			uid = "";
		}
		this.uniqueID = uid;
	}

	public AbstractModel(JSONObject json) throws InvalidJSONException {
		// System.out.println(json.toString());
		try {
			this.uniqueID = json.getString("uniqueID");
			this.name = json.getString("nom");
			this.position = new Position(json.getJSONObject("position"));
		} catch (JSONException e) {
			throw new InvalidJSONException(json.toString());
		}

	}

	/**
	 * Convert this object to a JSON object for representation
	 * 
	 * @throws JSONException
	 */
	@Override
	public JSONObject toJSON() throws JSONException {
		JSONObject json = new JSONObject();

		json.put("uniqueID", this.uniqueID);
		json.put("nom", this.name);
		json.put("position", this.position.toJSON());

		return json;
	}

	@Override
	public String getUniqueID() {
		return uniqueID;
	}

	@Override
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public void setPosition(Position position) {
		this.position = position;
	}
}
