package com.cg.cars.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7267569579560284910L;
	Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	public CustomerNotFoundException(String message) {
		super(message);
		log.info("Customer not Found !!");
	}

}
