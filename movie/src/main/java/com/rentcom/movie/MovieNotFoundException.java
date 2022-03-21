package com.rentcom.movie;

public class MovieNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MovieNotFoundException(String id) {
		super("Could not find movie " + id);
	}
}
