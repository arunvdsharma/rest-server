package org.rest.server.core;

import org.rest.server.core.components.Bean;
import org.rest.server.core.components.BeanType;

public interface BeanCreator {

	Bean createBean(BeanType beanType, Bean bean);
}
