package com.cg.cars.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2952361924217442175L;
	Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	public PaymentNotFoundException(String msg) {
		super(msg);
		log.info("Payment not Found !!");
	}

}
