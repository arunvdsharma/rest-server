package org.rest.server.core.runtime;

import org.rest.server.core.components.BeanClass;
import org.rest.server.core.exception.ClassCompilationException;

public interface RuntimeCompiler {

	void registerBean(BeanClass bean) throws ClassCompilationException;	
	
}
