package org.rest.server.runtime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Controller 
class ServerContainer {
	
	@Autowired
	private GenericWebApplicationContext context;
	
	public void registerController(String beanName, Object bean){		
		if(!context.containsBean(beanName)){
			context.getBeanFactory().registerSingleton(beanName, bean);
			context.getBeansOfType(RequestMappingHandlerMapping.class)
			   .forEach((k, v) -> v.afterPropertiesSet());
		}
	}
	
}
