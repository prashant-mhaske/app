package com.cg.cars.exceptions;

public class InvalidPasswordException extends RuntimeException{

	private static final long serialVersionUID = -8189336152470283801L;
	public InvalidPasswordException(String msg) {
		super(msg);
	}
	
}
