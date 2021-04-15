package com.cg.cars.exceptions;

public class AdminNotFoundException extends RuntimeException{
	
	String message;
	public AdminNotFoundException(String message)
	{
		this.message= message;
	}
	
	@Override
	public String getMessage()
	{
		return message;
	}

}
