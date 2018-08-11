package org.rest.server.core.exception;


public class DuplicateBeanRegistrationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7760410961517970217L;

	public DuplicateBeanRegistrationException(Throwable t){
		super(t);
	}
	
	public DuplicateBeanRegistrationException(String message){
		super(message);
	}
}
