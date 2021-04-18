package com.cg.cars.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AppointmentNotFoundException extends RuntimeException {
	Logger log = LoggerFactory.getLogger(AppointmentNotFoundException.class);

	

	private static final long serialVersionUID = 1L;

	public AppointmentNotFoundException(String msg) {
		super(msg);
		log.info("Appointment not Found !!");
	}


	


}