package org.rest.server.core.factory;

import java.util.List;
import java.util.Optional;

import org.rest.server.app.vo.APIBeanVO;
import org.rest.server.app.vo.BeanVO;
import org.rest.server.core.components.BeanClass;
import org.rest.server.core.components.BeanType;
import org.rest.server.core.components.BeanMethod;
import org.rest.server.core.utils.CommonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class APIBeanFactoryImpl implements APIBeanFactory {

	@Autowired
	private BeanBuilder beanBuilder;

	@Override
	public BeanClass createBeanClass(BeanType beanType, BeanVO beanVO) {
		BeanClass bean = null;
		
		//method to validate if Bean qualifies to be a valid Bean object or not.
		validateBeanObject(beanVO);
		
		beanBuilder.configure(beanVO.getClassName());
		beanBuilder.setImports(beanVO.getImportsList());
		List<BeanMethod> methodList = beanVO.getMethods();
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
		CommonValidator.throwExceptionIfNull(bean, bean.getClassName(), bean.getMethods(), bean.getImportsList());
	}

}
