package com.cg.cars.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CarNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8283163009295357365L;
	Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	public CarNotFoundException(String msg) {
		super(msg);
		log.info("Car not Found !!");
	}

}
