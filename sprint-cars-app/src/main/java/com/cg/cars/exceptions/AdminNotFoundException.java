package com.cg.cars.exceptions;

public class AdminNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 4372259374757753073L;
	public AdminNotFoundException(String message)
	{
		super(message);
	}
	

}
