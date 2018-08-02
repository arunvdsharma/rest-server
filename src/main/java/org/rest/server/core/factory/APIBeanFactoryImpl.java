package org.rest.server.core.factory;

import java.util.List;
import java.util.Optional;

import org.rest.server.common.utils.CommonUtils;
import org.rest.server.core.builder.APIBuilder;
import org.rest.server.core.builder.BeanBuilder;
import org.rest.server.core.components.Bean;
import org.rest.server.core.components.BeanType;
import org.rest.server.core.components.MethodBody;
import org.rest.server.web.ui.vos.APIBeanVO;
import org.rest.server.web.ui.vos.BeanVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class APIBeanFactoryImpl implements APIBeanFactory {

	@Autowired
	private BeanBuilder beanBuilder;

	@Override
	public Bean createBeanClass(BeanType beanType, BeanVO beanVO) {
		Bean bean = null;
		validateBeanObject(beanVO);
		beanBuilder.configure(beanVO.getClassName());
		beanBuilder.addImports(beanVO.getImportsList());
		List<MethodBody> methodList = beanVO.getMethods();
		Optional.ofNullable(methodList).ifPresent(list -> list.forEach(item -> {
			beanBuilder.addMethod(item);
		}));
		
		if (beanType == BeanType.CONTROLLER) {
			APIBuilder controllerBuilder = (APIBuilder) beanBuilder;
			APIBeanVO cBean = (APIBeanVO) beanVO;
			controllerBuilder.addControllerMapping(cBean.getRequestMappingURL());
			bean = controllerBuilder.buildBean();
			
		} else {
			bean = beanBuilder.buildBean();
		}
		
		
		return bean;
	}
	
	private void validateBeanObject(BeanVO bean){
		CommonUtils.checkIfArgumentIsNull(bean);
		CommonUtils.checkIfArgumentIsNull(bean.getClassName());
		CommonUtils.checkIfArgumentIsNull(bean.getMethods());
		CommonUtils.checkIfArgumentIsNull(bean.getImportsList());
	}

}
