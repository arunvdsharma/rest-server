package org.rest.server.core;

import java.util.List;
import java.util.Optional;

import org.rest.server.core.builder.BeanBuilder;
import org.rest.server.core.builder.ControllerBuilder;
import org.rest.server.core.components.Bean;
import org.rest.server.core.components.BeanType;
import org.rest.server.core.components.ControllerBean;
import org.rest.server.core.components.MethodBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class BeanCreatorImpl implements BeanCreator {

	@Autowired
	private BeanBuilder beanBuilder;

	@Override
	public Bean createBean(BeanType beanType, Bean bean) {
		beanBuilder.configure(bean.getClassSignature());
		
		List<MethodBody> methodList = bean.getMethods();
		Optional.ofNullable(methodList).ifPresent(list -> list.forEach(item -> {
			beanBuilder.addMethod(item);
		}));
		
		if (beanType == BeanType.CONTROLLER) {
			ControllerBuilder controllerBuilder = (ControllerBuilder) beanBuilder;
			ControllerBean cBean = (ControllerBean) bean;
			controllerBuilder.addControllerMapping(cBean.getRequestMappingURL());
			return controllerBuilder.build();
		} else {
			return beanBuilder.build();
		}
	}

}
