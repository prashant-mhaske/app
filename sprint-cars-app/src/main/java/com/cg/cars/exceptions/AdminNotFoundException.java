package com.cg.cars.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdminNotFoundException extends RuntimeException {
	Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	private static final long serialVersionUID = 4372259374757753073L;

	public AdminNotFoundException(String message) {
		super(message);
		log.info("Admin not Found !!");
	}

}
