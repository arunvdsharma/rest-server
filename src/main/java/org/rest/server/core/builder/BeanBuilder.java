package org.rest.server.core.builder;

import org.rest.server.core.components.Bean;
import org.rest.server.core.components.MethodBody;

public interface BeanBuilder {

	BeanBuilder configure(String classSignature);
	BeanBuilder addMethod(MethodBody methodBody);
	Bean buildObject();
	String buildString();
}
