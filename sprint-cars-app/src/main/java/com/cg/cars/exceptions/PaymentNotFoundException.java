package com.cg.cars.exceptions;

public class PaymentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2952361924217442175L;
	
	public PaymentNotFoundException(String msg)
	{
		super(msg);
	}
    @Override
    public String getMessage()
    {
    	return super.getMessage();
    }
}
