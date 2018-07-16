package org.rest.server.components;

public interface ControllerBuilderFactory {

	ControllerBuilder getControllerBuilder(String controllerName);
}
