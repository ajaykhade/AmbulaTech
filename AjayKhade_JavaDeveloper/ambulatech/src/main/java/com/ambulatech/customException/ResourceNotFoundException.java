package com.ambulatech.customException;

public class ResourceNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String data, String type, long parameter) {
		super(data + " with " + type + " = " + parameter + " not found.");		
	}

}
