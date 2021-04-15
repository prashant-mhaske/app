package com.cg.cars.tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cars.exceptions.PaymentNotFoundException;
import com.cg.cars.models.Card;
import com.cg.cars.models.Payment;
import com.cg.cars.services.PaymentService;

@SpringBootTest
public class PaymentSeviceTest {
	
	@Autowired
	PaymentService paymentService;
	
	Card card;
	Payment payment;
	long id;
	@BeforeEach
	public void init() {
		card=new Card("Dan", "5643245776543456", LocalDate.of(2025, 06, 12), 789);
		payment=new Payment(1, "Card", "Pending", card);
		id=paymentService.addPayment(payment).getId();
	}
	
	@Test
	public void testAddPayment() {
		paymentService.removePayment(id);
		Payment addedPayment=paymentService.addPayment(payment);
		id=addedPayment.getId();
		assertThat(addedPayment.toString().equals(payment.toString()));
	}
	
	@Test
	public void testGetPayment() {
		assertThat(paymentService.getPaymentDetails(id).toString().equals(payment.toString()));
	}
	
	@Test
	public void negativeTestGetPayment() {
		try {
			paymentService.getPaymentDetails(2);
		}
		catch(PaymentNotFoundException e) {
			assertThat(e.getMessage().equals("No payment with id 2 found"));
		}
	}
	
	@Test
	public void NegativeTestDelete() {
		try {
			paymentService.removePayment(2);
		}
		catch (PaymentNotFoundException e) {
			assertThat(e.getMessage().equals("No payment with id 2 found"));
		}
	}
	
	@AfterEach
	public void testDelete() {
		paymentService.removePayment(id);
	}
}
