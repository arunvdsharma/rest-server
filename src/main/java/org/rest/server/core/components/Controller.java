package org.rest.server.core.components;

public class Controller extends Bean {

	private String requestMappingURL;
	
	public Controller(String classSignature){
		super(classSignature);
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
