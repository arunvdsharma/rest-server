package org.rest.server.runtime;

import org.rest.server.core.components.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
class ServerContainer {
	
	@Autowired
	private GenericWebApplicationContext context;
	
	public void registerBean(String beanName, Bean bean){		
		if(!context.containsBean(beanName)){
			context.getBeanFactory().registerSingleton(beanName, bean);
			context.getBeansOfType(RequestMappingHandlerMapping.class)
			   .forEach((k, v) -> v.afterPropertiesSet());
		}
	}
	
}
