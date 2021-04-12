package com.cg.cars.exceptions;

public class CustomerNotFoundException extends RuntimeException {

	String message;
	public CustomerNotFoundException(String message)
	{
		this.message= message;
	}
	
	@Override
	public String getMessage()
	{
		return message;
	}

}
