package com.cg.cars.exceptions;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7267569579560284910L;

	public CustomerNotFoundException(String message)
	{
		super(message);
	}
	
}
