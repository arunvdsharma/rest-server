package org.rest.server.core.facade;

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
}
