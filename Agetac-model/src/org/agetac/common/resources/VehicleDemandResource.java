package org.agetac.common.resources;

import org.agetac.common.dto.VehicleDemandDTO;
import org.restlet.resource.Delete;
import org.restlet.resource.Post;
import org.restlet.resource.Put;


public interface VehicleDemandResource {

	@Post
	public abstract VehicleDemandDTO add(VehicleDemandDTO demand);

	@Put
	public abstract void update(VehicleDemandDTO demand);

	@Delete
	public abstract void remove();


}
