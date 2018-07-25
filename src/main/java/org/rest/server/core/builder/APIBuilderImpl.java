package org.rest.server.core.builder;

import org.rest.server.common.utils.CommonUtils;
import org.rest.server.core.components.APIBean;
import org.rest.server.core.components.MethodBody;
import org.springframework.stereotype.Component;

@Component
class APIBuilderImpl implements APIBuilder {

	private static String INTERNAL_PACKAGE_NAME = APIBuilderImpl.class.getPackage().getName();

	private APIBean bean;

	@Override
	public APIBuilder configure(String classSignature) {
		CommonUtils.checkIfArgumentIsNull("classSignature", classSignature);
		bean = new APIBean(classSignature);
		bean.setPackageName(INTERNAL_PACKAGE_NAME);
		return this;
	}

	@Override
	public APIBuilder addMethod(MethodBody methodBody) {
		CommonUtils.checkIfArgumentIsNull("methodBody", methodBody);
		bean.addMethod(methodBody);
		return this;
	}

	@Override
	public APIBuilder addControllerMapping(String requestMappingUrl) {
		CommonUtils.checkIfArgumentIsNull("Controller requestMappingUrl", requestMappingUrl);
		bean.setRequestMappingURL(requestMappingUrl);
		return this;
	}

	@Override
	public APIBean buildObject() {
		APIBean newBean = bean;
		bean = null;
		return newBean;
	}

	public String buildString() {
		StringBuilder sb = new StringBuilder();
		sb.append("package ").append(bean.getPackageName()).append("\n");
		bean.getImportsList().forEach((importItem) -> sb.append("import ").append(importItem).append(";\n"));
		sb.append(bean.getClassSignature()).append("{\n");

		bean.getMethods().forEach((method) -> sb.append(buildMethod(method)).append("\n"));

		sb.append("}");

		return sb.toString();
	}

	private String buildMethod(MethodBody methodBody) {
		StringBuilder sb = new StringBuilder();
		sb.append(methodBody.getRequestMapping()).append("\n"); // Adding
																// RequestMapping
		sb.append(methodBody.getMethodSignature()).append(" ");
		sb.append("{");
		methodBody.getBodyStatements().forEach((statement) -> sb.append(statement));
		sb.append("}");
		return sb.toString();
	}

}
