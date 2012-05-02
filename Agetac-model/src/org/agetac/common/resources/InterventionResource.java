package org.agetac.common.resources;

import org.agetac.common.dto.InterventionDTO;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;


public interface InterventionResource {

	@Post
	InterventionDTO add(InterventionDTO intervention);
	
	@Put
	void update(InterventionDTO intervention);

	@Get
	InterventionDTO retrieve();

}
