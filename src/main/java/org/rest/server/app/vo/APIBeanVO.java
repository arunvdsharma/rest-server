package org.rest.server.app.vo;

public class APIBeanVO extends BeanVO {
	private String requestMappingURL;

	
	public APIBeanVO(){
		super();
	}
	public APIBeanVO(String classSignature){
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
