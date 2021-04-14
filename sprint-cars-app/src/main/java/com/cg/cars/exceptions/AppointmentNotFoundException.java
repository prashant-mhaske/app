package com.cg.cars.exceptions;

public class AppointmentNotFoundException extends RuntimeException {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
	
    public AppointmentNotFoundException(String msg) {
		super(msg);
		
	}

	@Override
    public String getMessage()
    {
		return super.getMessage();
    }
	

}