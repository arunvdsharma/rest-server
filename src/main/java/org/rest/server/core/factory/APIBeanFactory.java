package org.rest.server.core.factory;

import org.rest.server.app.vo.BeanVO;
import org.rest.server.core.components.BeanClass;
import org.rest.server.core.components.BeanType;
import org.rest.server.core.exception.ClassCompilationException;

public interface APIBeanFactory {

	BeanClass createBeanClass(BeanType beanType, BeanVO bean);
}
