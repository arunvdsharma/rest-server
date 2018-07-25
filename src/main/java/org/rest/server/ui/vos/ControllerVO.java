package org.rest.server.ui.vos;

public class ControllerVO extends BeanVO{
	private String requestMappingURL;

	public ControllerVO(String classSignature){
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
