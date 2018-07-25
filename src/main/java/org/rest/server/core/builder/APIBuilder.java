package org.rest.server.core.builder;

public interface APIBuilder extends BeanBuilder {
	
	APIBuilder addControllerMapping(String url);
}
