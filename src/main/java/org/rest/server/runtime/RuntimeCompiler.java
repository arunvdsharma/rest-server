package org.rest.server.runtime;

import org.rest.server.common.components.ClassCompilationException;
import org.rest.server.core.components.Bean;

public interface RuntimeCompiler {

	void registerBean(Bean bean) throws ClassCompilationException;	
	
}
