package com.weatherapp.services.exceptions;

/**
 * Runtime error class throw by services if the response returns an invalid object
 * 
 * @author LuisDaniel
 *
 */
public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
