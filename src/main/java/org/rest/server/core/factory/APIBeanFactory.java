package org.rest.server.core.factory;

import org.rest.server.core.components.Bean;
import org.rest.server.core.components.BeanType;
import org.rest.server.web.ui.vos.BeanVO;

public interface APIBeanFactory {

	Bean createBeanClass(BeanType beanType, BeanVO bean);
}
