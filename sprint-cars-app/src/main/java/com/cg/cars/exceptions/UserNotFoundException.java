package com.cg.cars.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserNotFoundException extends RuntimeException {


	Logger log = LoggerFactory.getLogger(UserNotFoundException.class);

	public UserNotFoundException(String message) {
		super(message);
		log.info("User not Found !!");
}
}
