package com.weatherapp.services.exceptions;

public class WeathermapException extends Exception {
	private static final long serialVersionUID = 1L;

	public WeathermapException(String msg) {
		super(msg);
	}
	
	public WeathermapException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
