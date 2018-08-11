package org.rest.server.app.facade;

import org.rest.server.app.vo.BeanVO;
import org.rest.server.core.exception.ClassCompilationException;

/**
 * 
 * @author Arun Sharma
 *
 */
public interface AppFacade {

	void createServiceClass(BeanVO beanVO)throws ClassCompilationException;

	void createRepositoryClass(BeanVO beanVO) throws ClassCompilationException;

	void createBeanClass(BeanVO beanVO)throws ClassCompilationException;

	void createControllerClass(BeanVO beanVO)throws ClassCompilationException;

}
