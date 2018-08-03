package org.rest.server.app.facade;

import org.rest.server.app.vo.BeanVO;
import org.rest.server.core.components.BeanType;
import org.rest.server.core.factory.APIBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * AppFacade is the implementation of core business logic to create and expose RESTful Services 
 * at runtime.
 * @author Arun Sharma
 *
 */
@Component
class AppFacadeImpl implements AppFacade{

	@Autowired
	private APIBeanFactory factory;
	
	
	@Override
	public void createControllerClass(BeanVO beanVO){
		factory.createBeanClass(BeanType.CONTROLLER, beanVO);
	}
	
	@Override
	public void createBeanClass(BeanVO beanVO){
		factory.createBeanClass(BeanType.BEAN, beanVO);
	}
	
	@Override
	public void createRepositoryClass(BeanVO beanVO){
		factory.createBeanClass(BeanType.REPOSITORY, beanVO);
	}
	
	@Override
	public void createServiceClass(BeanVO beanVO){
		factory.createBeanClass(BeanType.SERVICE, beanVO);
	}
}
