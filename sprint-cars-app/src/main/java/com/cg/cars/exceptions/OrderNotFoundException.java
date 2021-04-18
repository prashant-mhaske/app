package com.cg.cars.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	Logger log = LoggerFactory.getLogger(OrderNotFoundException.class);

	public OrderNotFoundException(String msg) {
		super(msg);
		log.info("Order not Found !!");
	}

}
