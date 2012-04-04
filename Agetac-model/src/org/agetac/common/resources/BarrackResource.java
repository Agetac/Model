package org.agetac.common.resources;

import org.agetac.common.dto.BarrackDTO;
import org.restlet.resource.Delete;
import org.restlet.resource.Post;
import org.restlet.resource.Put;


public interface BarrackResource {

	@Post
	public abstract BarrackDTO add(BarrackDTO barrack);

	@Put
	public abstract void update(BarrackDTO barrack);

	@Delete
	public abstract void remove();

}
