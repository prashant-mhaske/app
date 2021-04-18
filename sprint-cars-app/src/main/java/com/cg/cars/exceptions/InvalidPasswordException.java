package com.cg.cars.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidPasswordException extends RuntimeException {

	private static final long serialVersionUID = -8189336152470283801L;
	Logger log = LoggerFactory.getLogger(InvalidPasswordException.class);

	public InvalidPasswordException(String msg) {
		super(msg);
		log.info("Password not Found !!");
	}

}
