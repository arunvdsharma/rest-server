package org.rest.server.app.facade;

import org.rest.server.app.vo.BeanVO;

/**
 * 
 * @author Arun Sharma
 *
 */
public interface AppFacade {

	void createServiceClass(BeanVO beanVO);

	void createRepositoryClass(BeanVO beanVO);

	void createBeanClass(BeanVO beanVO);

	void createControllerClass(BeanVO beanVO);

}
