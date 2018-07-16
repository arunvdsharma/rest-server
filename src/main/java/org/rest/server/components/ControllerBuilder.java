package org.rest.server.components;

public interface ControllerBuilder {

	ControllerBuilder initController(String className);
	ControllerBuilder addMethod(String methodName);
	ControllerBuilder addRequestMapping(String url);
	ControllerBuilder addMethodResponse(String methodName);
	ControllerBean buildController();
}
