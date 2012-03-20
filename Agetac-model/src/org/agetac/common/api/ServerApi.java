package org.agetac.common.api;

import org.agetac.common.exception.BadResponseException;
import org.restlet.representation.Representation;

public interface ServerApi {
	
	public Representation getResource(String resType, String resUniqueID) throws BadResponseException;
	
	public Representation putResource(String resType, String resUniqueID,	Representation resRepresentation) throws BadResponseException;
	
	public Representation postResource(String resType, String resUniqueID, Representation resRepresentation) throws BadResponseException;
	
	public void deleteResource(String resType, String resUniqueID) throws BadResponseException;
	
}
