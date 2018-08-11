package org.rest.server.app.facade;

import org.rest.server.app.vo.BeanVO;
import org.rest.server.core.components.BeanClass;
import org.rest.server.core.components.BeanType;
import org.rest.server.core.exception.ClassCompilationException;
import org.rest.server.core.factory.APIBeanFactory;
import org.rest.server.core.runtime.RuntimeCompiler;
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
	
	@Autowired
	private RuntimeCompiler compiler;
	
	@Override
	public void createControllerClass(BeanVO beanVO) throws ClassCompilationException {
		createAndRegisterBean(BeanType.CONTROLLER, beanVO);
	}
	
	@Override
	public void createBeanClass(BeanVO beanVO) throws ClassCompilationException{
		createAndRegisterBean(BeanType.BEAN, beanVO);
	}
	
	@Override
	public void createRepositoryClass(BeanVO beanVO)throws ClassCompilationException{
		createAndRegisterBean(BeanType.REPOSITORY, beanVO);
	}
	
	@Override
	public void createServiceClass(BeanVO beanVO)throws ClassCompilationException{
		createAndRegisterBean(BeanType.SERVICE, beanVO);
	}
	
	private void createAndRegisterBean(BeanType beanType, BeanVO beanVO) throws ClassCompilationException{
		BeanClass bean = factory.createBeanClass(beanType, beanVO);
		compiler.registerBean(bean);
	}
}
