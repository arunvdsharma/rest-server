package org.rest.server.core.factory;

interface APIBuilder extends BeanBuilder {
	APIBuilder addControllerMapping(String url);
}
