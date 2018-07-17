package org.rest.server.core.components;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class MethodBody {

	private String methodSignature;

	private List<String> bodyStatements;

	private String requestMapping;

	public MethodBody() {
	}

	public MethodBody(String methodSignature) {
		this.bodyStatements = new ArrayList<>();
		this.methodSignature = methodSignature;
		this.requestMapping = StringUtils.EMPTY;
	}

	public String getMethodSignature() {
		return methodSignature;
	}

	public void setMethodSignature(String methodSignature) {
		this.methodSignature = methodSignature;
	}

	public String getRequestMapping() {
		return requestMapping;
	}

	public void setRequestMapping(String requestMapping) {
		this.requestMapping = requestMapping;
	}

	public void addStatement(String statement) {
		this.bodyStatements.add(statement);
	}
	
	public List<String> getBodyStatements(){
		return bodyStatements;
	}

}
