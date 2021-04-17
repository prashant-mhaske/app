package com.cg.cars.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.exceptions.PaymentNotFoundException;
import com.cg.cars.models.Payment;
import com.cg.cars.repositories.IPaymentRepository;

/**
 *
 * @author TEAM 2 MEMBERS: Abhishek Sen Prashant Mhaske Rishabh Gupta Akshay
 *         Talekar Nikhil Nichit
 *
 */

@Service
public class PaymentService implements IPaymentService {

	@Autowired
	IPaymentRepository paymentRepository;

	/*
	 * Add payment details in database.
	 */
	@Override
	public Payment addPayment(Payment payment) {
		return paymentRepository.save(payment);
	}

	/*
	 * Remove payment details from database using payment Id.
	 */
	@Override
	public Payment removePayment(long id) {
		Payment payment = getPaymentDetails(id);
		paymentRepository.deleteById(id);
		return payment;
	}

	/*
	 * Update payment details using payment Id.
	 */
	@Override
	public Payment updatePayment(long id, Payment payment) {
		return paymentRepository.save(payment);
	}

	/*
	 * Retrieving payment details from database using payment Id.
	 */
	@Override
	public Payment getPaymentDetails(long id) {
		return paymentRepository.findById(id)
				.orElseThrow(() -> new PaymentNotFoundException("No payment with id " + id + " found"));
	}

	/*
	 * Retrieving all payment details from database.
	 */
	@Override
	public List<Payment> getAllPaymentDetails() {
		List<Payment> payments = new ArrayList<>();
		paymentRepository.findAll().forEach(p -> payments.add(p));
		return payments;
	}

}
