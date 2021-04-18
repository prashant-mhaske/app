package com.cg.cars.exceptions;

public class CardNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 4213290295939422558L;
	
	public CardNotFoundException(String msg) {
		super(msg);
	}
	
}
