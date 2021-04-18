package com.cg.cars.exceptions;

public class CarNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8283163009295357365L;
	
	public CarNotFoundException(String msg) {
		super(msg);
	}
	
}
