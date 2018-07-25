package org.rest.server.core.factory;

import java.util.List;
import java.util.Optional;

import org.rest.server.core.builder.BeanBuilder;
import org.rest.server.core.builder.ControllerBuilder;
import org.rest.server.core.components.Bean;
import org.rest.server.core.components.BeanType;
import org.rest.server.core.components.MethodBody;
import org.rest.server.ui.vos.BeanVO;
import org.rest.server.ui.vos.ControllerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class RestBeanFactoryImpl implements RestBeanFactory {

	@Autowired
	private BeanBuilder beanBuilder;

	@Override
	public Bean getBean(BeanType beanType, BeanVO bean) {
		beanBuilder.configure(bean.getClassSignature());
		
		List<MethodBody> methodList = bean.getMethods();
		Optional.ofNullable(methodList).ifPresent(list -> list.forEach(item -> {
			beanBuilder.addMethod(item);
		}));
		
		if (beanType == BeanType.CONTROLLER) {
			ControllerBuilder controllerBuilder = (ControllerBuilder) beanBuilder;
			ControllerVO cBean = (ControllerVO) bean;
			controllerBuilder.addControllerMapping(cBean.getRequestMappingURL());
			return controllerBuilder.buildObject();
		} else {
			return beanBuilder.buildObject();
		}
	}

}
