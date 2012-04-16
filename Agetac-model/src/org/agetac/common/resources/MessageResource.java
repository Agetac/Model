package org.agetac.common.resources;

import org.agetac.common.dto.MessageDTO;
import org.restlet.resource.Post;
import org.restlet.resource.Put;

public interface MessageResource {

	@Post
	public abstract MessageDTO add(MessageDTO message);
}
