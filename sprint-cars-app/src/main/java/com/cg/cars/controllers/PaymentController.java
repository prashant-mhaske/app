package com.cg.cars.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cars.models.Payment;
import com.cg.cars.services.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	PaymentService paymentService;
	
	@PostMapping("add")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment){
		Payment p=paymentService.addPayment(payment);
		return new ResponseEntity<Payment>(p, HttpStatus.OK);
	}
	
	@DeleteMapping("remove/{id}")
	public ResponseEntity<Payment> removePayment(@PathVariable("id") long id){
		Payment p=paymentService.removePayment(id);
		return new ResponseEntity<Payment>(p,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment){
		Payment p=paymentService.updatePayment(0, payment);
		return new ResponseEntity<Payment>(p, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Payment> getPaymentDetails(@PathVariable("id") long id) {
		Payment p=paymentService.getPaymentDetails(id);
		return new ResponseEntity<Payment>(p, HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public List<Payment> getAllPaymentDetails() {
		return paymentService.getAllPaymentDetails();
	}
	

}
