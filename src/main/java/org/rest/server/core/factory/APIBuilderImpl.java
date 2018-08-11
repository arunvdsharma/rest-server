package org.rest.server.core.factory;

import java.util.List;

import org.rest.server.core.components.APIBeanClass;
import org.rest.server.core.components.BeanMethod;
import org.rest.server.core.utils.CommonValidator;
import org.rest.server.core.utils.Constants;
import org.springframework.stereotype.Component;


@Component
class APIBuilderImpl implements APIBuilder {

	private static String DEFAULT_PACKAGE_NAME = APIBuilderImpl.class.getPackage().getName();

	private APIBeanClass bean;

	@Override
	public APIBuilder configure(String className) {
		CommonValidator.throwExceptionIfNull(className);
		bean = new APIBeanClass(className);
		bean.setPackageName(DEFAULT_PACKAGE_NAME);
		return this;
	}

	@Override
	public APIBuilder addMethod(BeanMethod methodBody) {
		CommonValidator.throwExceptionIfNull(methodBody);
		bean.addMethod(methodBody);
		return this;
	}

	@Override
	public APIBuilder addControllerMapping(String requestMappingUrl) {
		bean.setRequestMappingURL(requestMappingUrl);
		return this;
	}
	
	public APIBuilder setImports(List<String> importList){
		bean.setImportsList(importList);
		return this;
	}

	@Override
	public APIBeanClass buildBean() {
		APIBeanClass newBean = bean;
		String javaClassCode = this.buildJavaCode();
		newBean.setJavaCode(javaClassCode);
		bean = null;
		return newBean;
	}

	private String buildJavaCode() {
		StringBuilder sb = new StringBuilder();
		String classCanonicalName = bean.getPackageName() + Constants.Dot + bean.getClassName();
		bean.setClassCanonicalName(classCanonicalName);
		
		//Creating Class structure
		sb.append("package ").append(bean.getPackageName()).append(Constants.ColonWithNewLine); //Define Package
		bean.getImportsList().forEach((importItem) -> sb.append("import ").append(importItem).append(Constants.ColonWithNewLine)); //Define Imported Classes
		
		sb.append(Constants.Annotation_RestController).append(Constants.NewLine);
		sb.append("public class ").append(bean.getClassName()).append(" extends org.rest.server.core.components.Bean")
			.append(Constants.CurlyBraceOpen).append(Constants.NewLine);		
		bean.getMethods().forEach((method) -> sb.append(BuilderUtility.buildMethod(method)).append(Constants.NewLine));
		sb.append(Constants.CurlyBraceClose);

		return sb.toString();
	}

	

}
