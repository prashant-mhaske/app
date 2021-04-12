package com.cg.cars.exceptions;

public class OrderNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public OrderNotFoundException(String msg) {
		super(msg);
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
