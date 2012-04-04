package org.agetac.common.resources;

import java.util.Collection;

import org.agetac.common.dto.BarrackDTO;
import org.restlet.resource.Get;


public interface BarracksResource {

	@Get
	public abstract Collection<BarrackDTO> retrieve();

}
