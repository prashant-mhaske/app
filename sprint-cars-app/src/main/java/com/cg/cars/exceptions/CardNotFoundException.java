package com.cg.cars.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CardNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4213290295939422558L;
	Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	public CardNotFoundException(String msg) {
		super(msg);
		log.info("Card not Found !!");
	}

}
