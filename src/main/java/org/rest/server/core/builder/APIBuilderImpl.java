package org.rest.server.core.builder;

import java.util.List;

import org.rest.server.common.utils.CommonUtils;
import org.rest.server.core.components.APIBean;
import org.rest.server.core.components.MethodBody;
import org.springframework.stereotype.Component;

@Component
class APIBuilderImpl implements APIBuilder {

	private static String INTERNAL_PACKAGE_NAME = APIBuilderImpl.class.getPackage().getName();

	private APIBean bean;

	@Override
	public APIBuilder configure(String className) {
		CommonUtils.checkIfArgumentIsNull(className);
		bean = new APIBean(className);
		bean.setPackageName(INTERNAL_PACKAGE_NAME);
		return this;
	}

	@Override
	public APIBuilder addMethod(MethodBody methodBody) {
		CommonUtils.checkIfArgumentIsNull(methodBody);
		bean.addMethod(methodBody);
		return this;
	}

	@Override
	public APIBuilder addControllerMapping(String requestMappingUrl) {
		//CommonUtils.checkIfArgumentIsNull(requestMappingUrl);
		bean.setRequestMappingURL(requestMappingUrl);
		return this;
	}
	
	public APIBuilder addImports(List<String> importList){
		bean.setImportsList(importList);
		return this;
	}

	@Override
	public APIBean buildBean() {
		APIBean newBean = bean;
		newBean.setJavaCode(this.buildJavaCode());
		bean = null;
		return newBean;
	}

	private String buildJavaCode() {
		StringBuilder sb = new StringBuilder();
		String classCanonicalName = bean.getPackageName()+"."+bean.getClassName();
		bean.setClassCanonicalName(classCanonicalName);
		
		//Creating Class structure
		sb.append("package ").append(bean.getPackageName()).append(";\n"); //Define Package
		bean.getImportsList().forEach((importItem) -> sb.append("import ").append(importItem).append(";\n")); //Define Imported Classes
		
		sb.append("@RestController\n");
		sb.append("public class ").append(bean.getClassName()).append(" extends org.rest.server.core.components.Bean{\n");		
		bean.getMethods().forEach((method) -> sb.append(buildMethod(method)).append("\n"));
		sb.append("}");

		return sb.toString();
	}

	private String buildMethod(MethodBody methodBody) {
		StringBuilder sb = new StringBuilder();
		sb.append(methodBody.getRequestMapping()).append("\n"); // Adding
																// RequestMapping
		sb.append(methodBody.getMethodSignature());
		sb.append("{\n");
		methodBody.getBodyStatements().forEach((statement) -> sb.append(statement).append("\n"));
		sb.append("}\n");
		return sb.toString();
	}

}
