package org.rest.server.core.factory;

import org.rest.server.core.components.ControllerBean;

public interface ControllerBuilder {

	ControllerBuilder configureClass(String className);

	ControllerBuilder addMethod(String methodName);

	ControllerBuilder addRequestMapping(String url);

	ControllerBuilder addMethodResponse(String methodName);

	ControllerBean buildController();
}
