package org.agetac.common.model.sign;


import org.agetac.common.exception.InvalidJSONException;
import org.agetac.common.model.impl.Position;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.json.JSONException;
import org.json.JSONObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractModel implements IJsonable, IModel {

	protected String uniqueID;
	protected String nom;
	protected Position position;

	public AbstractModel(String nom, Position position){
		if (nom == null) {
			nom = "";
		}
		if (position == null) {
			position = new Position(0, 0);
		}
		
		this.nom = nom;
		this.position = position;
	}
	
	public AbstractModel(String uid, String nom, Position position) {
		this(nom, position);
		if (uid == null) {
			uid = "";
		}
		this.uniqueID = uid;
	}

	public AbstractModel(JSONObject json) throws InvalidJSONException {
		try {
			this.uniqueID = json.getString("uniqueID");
			this.nom = json.getString("nom");
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
		json.put("nom", this.nom);
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
		return nom;
	}

	@Override
	public void setName(String name) {
		this.nom = name;
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
