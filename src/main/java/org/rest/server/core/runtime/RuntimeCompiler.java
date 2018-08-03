package org.rest.server.core.runtime;

import org.rest.server.core.components.Bean;
import org.rest.server.core.exception.ClassCompilationException;

public interface RuntimeCompiler {

	void registerBean(Bean bean) throws ClassCompilationException;	
	
}
