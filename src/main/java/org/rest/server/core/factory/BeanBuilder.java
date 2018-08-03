package org.rest.server.core.factory;

import java.util.List;

import org.rest.server.core.components.Bean;
import org.rest.server.core.components.MethodBody;

interface BeanBuilder {
	
	BeanBuilder configure(String classSignature);

	BeanBuilder addMethod(MethodBody methodBody);

	BeanBuilder addImports(List<String> importList);

	Bean buildBean();
}
