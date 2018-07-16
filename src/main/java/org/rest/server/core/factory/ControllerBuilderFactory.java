package org.rest.server.core.factory;

public interface ControllerBuilderFactory {

	ControllerBuilder getControllerBuilder(String controllerName);
}
