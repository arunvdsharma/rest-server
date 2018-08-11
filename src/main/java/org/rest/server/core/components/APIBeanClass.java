package org.rest.server.core.components;

public class APIBeanClass extends BeanClass {

	private String requestMappingURL;
	
	public APIBeanClass(String className){
		super(className);
	}

	public String getRequestMappingURL() {
		return requestMappingURL;
	}

	public void setRequestMappingURL(String requestMappingURL) {
		this.requestMappingURL = requestMappingURL;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
