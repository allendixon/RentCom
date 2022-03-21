package com.rentcom.customer;

public class CustomerNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CustomerNotFoundException(String id) {
		super("Could not find customer " + id);
	}
}
