package org.rest.server.runtime;

import org.rest.server.core.components.Bean;

public interface RuntimeEnvironment {

//	Class<?> getBeanClass(String beanName);
	void registerBean(String beanName, Bean bean);
	
	
}
