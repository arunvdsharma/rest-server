package org.rest.server.core.factory;

import java.util.List;

import org.rest.server.core.components.BeanClass;
import org.rest.server.core.components.BeanMethod;

interface BeanBuilder {
	
	BeanBuilder configure(String classSignature);

	BeanBuilder addMethod(BeanMethod methodBody);

	BeanBuilder setImports(List<String> importList);

	BeanClass buildBean();
}
