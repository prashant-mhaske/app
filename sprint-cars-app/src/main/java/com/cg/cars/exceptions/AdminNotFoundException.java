package com.cg.cars.exceptions;

public class AdminNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 4372259374757753073L;
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
