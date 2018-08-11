package org.rest.server.core.runtime;

import static org.junit.Assert.assertNotNull;

import org.rest.server.core.components.BeanClass;
import org.rest.server.core.exception.DuplicateBeanRegistrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
class AppBeanContainer {
	
	@Autowired
	private GenericWebApplicationContext context;
	
	public void registerBean(String beanName, BeanClass bean){		
		if(!context.containsBean(beanName)){
			context.getBeanFactory().registerSingleton(beanName, bean);
			context.getBeansOfType(RequestMappingHandlerMapping.class)
			   .forEach((k, v) -> v.afterPropertiesSet());
		}else{
			throw new DuplicateBeanRegistrationException(bean.getClassCanonicalName()+" bean class is already registered in the context with '"+beanName+"'");
		}
	}
	
	public void removeBean(String beanName){
		assertNotNull(beanName);
		BeanDefinitionRegistry factory = 
				   (BeanDefinitionRegistry) context.getAutowireCapableBeanFactory();
		factory.removeBeanDefinition(beanName);
	}
	
	public void updateRegisteredBean(String beanName, BeanClass bean){
		this.removeBean(beanName);
		this.registerBean(beanName, bean);
	}
	
}
