package org.rest.server.core.factory;

import org.rest.server.core.components.Bean;
import org.rest.server.core.components.BeanType;
import org.rest.server.ui.vos.BeanVO;

public interface RestBeanFactory {

	Bean getBean(BeanType beanType, BeanVO bean);
}
