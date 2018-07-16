package org.rest.server.core.factory;

import org.rest.server.core.components.ControllerBean;
import org.springframework.stereotype.Component;

@Component
class ControllerBuilderImpl implements ControllerBuilder {

	private static String INTERNAL_PACKAGE_NAME = ControllerBuilderImpl.class.getPackage().getName();

	private StringBuilder sb;
	
	public ControllerBuilderImpl(){
		sb = new StringBuilder();
	}
	
	@Override
	public ControllerBuilder configureClass(String newClassName) {
		sb = new StringBuilder("package com.test.config;\n");
		return this;
	}

	@Override
	public ControllerBuilder addMethod(String methodName) {
		return this;
	}

	@Override
	public ControllerBuilder addRequestMapping(String url) {
		return this;
	}

	@Override
	public ControllerBuilder addMethodResponse(String methodName) {
		return this;
	}

	@Override
	public ControllerBean buildController() {
		// TODO Auto-generated method stub
		return null;
	}

}
