package org.rest.server.core.factory;

import org.rest.server.app.vo.BeanVO;
import org.rest.server.core.components.Bean;
import org.rest.server.core.components.BeanType;

public interface APIBeanFactory {

	Bean createBeanClass(BeanType beanType, BeanVO bean);
}
