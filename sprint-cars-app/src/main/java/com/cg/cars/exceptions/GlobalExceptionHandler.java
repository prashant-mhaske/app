package com.cg.cars.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	Logger log=LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler
	public ResponseEntity<Object> handleAdminNotFound(AdminNotFoundException ex){
		log.info("Admin Not Found");
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Object> handleCustomerNotFound(CustomerNotFoundException ex){
		log.info("Customer Not Found");
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFound(UserNotFoundException ex){
		log.info("User Not Found");
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<Object> handleInvalidPasswordException(InvalidPasswordException ex){
		log.info("Invalid Password Entered");
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(PaymentNotFoundException.class)
	public ResponseEntity<Object> handlePaymentNotFound(PaymentNotFoundException ex){
		log.info("Payment Not Found");
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CarNotFoundException.class)
	public ResponseEntity<Object> handlePaymentNotFound(CarNotFoundException ex){
		log.info("Car Not Found");
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<Object> handleOrdertNotFound(OrderNotFoundException ex){
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AppointmentNotFoundException.class)
	public ResponseEntity<Object> handleAppointmentNotFound(AppointmentNotFoundException ex){
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}

}
