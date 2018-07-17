package org.rest.server.core.builder;

public interface ControllerBuilder extends BeanBuilder {
	
	ControllerBuilder addControllerMapping(String url);
}
