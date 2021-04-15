package com.cg.cars.tests;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.cars.exceptions.PaymentNotFoundException;
import com.cg.cars.models.Card;
import com.cg.cars.models.Payment;
import com.cg.cars.repositories.IPaymentRepository;
import com.cg.cars.services.PaymentService;

@SpringBootTest
public class PaymentSeviceTest {
	
	@Autowired
	PaymentService paymentService;
	
	@MockBean
	IPaymentRepository paymentRepository;
	
	Payment payment;
	Card card;
	
	@BeforeEach
	public void init() {
		card=new Card("Dan", "5643245776543456", LocalDate.of(2025, 06, 12), 789);
		payment=new Payment(1, "Card", "Pending", card);
	}
	
	@Test
	public void addPaymentTest() {
		when(paymentRepository.save(payment)).thenReturn(payment);
		assertEquals(payment, paymentService.addPayment(payment));
		verify(paymentRepository,times(1)).save(payment);
	}
	
	@Test
	public void getAllPaymentTest() {
		Payment payment2=new Payment(2, "Card", "Successful", new Card("David", "5577664324543456", LocalDate.of(2023, 04, 12), 779));
		Payment payment3=new Payment(3, "Card", "Pending", new Card("Dan", "5643776543452456", LocalDate.of(2024, 05, 10), 189));
		
		List<Payment> payments=new ArrayList<>();
		payments.add(payment);
		payments.add(payment2);
		payments.add(payment3);
		when(paymentRepository.findAll()).thenReturn(Stream
				.of(payment,payment2,payment3).collect(Collectors.toList()));
		assertEquals(payments, paymentService.getAllPaymentDetails());
		verify(paymentRepository,times(1)).findAll();
	}
	
	@Test
	public void getPaymentByIdTest() {
		when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment));
		assertEquals(payment, paymentService.getPaymentDetails(1L));
		verify(paymentRepository,times(1)).findById(1L);
	}
	
	@Test
	public void getPaymentByIdNegativeTest() {
		when(paymentRepository.findById(2L)).thenThrow(PaymentNotFoundException.class);
		assertThrows(PaymentNotFoundException.class, () -> paymentService.getPaymentDetails(2L));
		verify(paymentRepository,times(1)).findById(2L);
	}
	
	@Test
	public void deletePaymentByIdTest() {
		when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment));
		when(paymentRepository.existsById(1L)).thenReturn(false);
		paymentService.removePayment(1L);
		verify(paymentRepository,times(1)).deleteById(1L);
		assertFalse(paymentRepository.existsById(1L));
	}
	
	@Test
	public void deletePaymentByIdNegativeTest() {
		when(paymentRepository.findById(2L)).thenThrow(PaymentNotFoundException.class);
		assertThrows(PaymentNotFoundException.class, () -> paymentService.removePayment(2L));
		verify(paymentRepository,times(0)).deleteById(2L);
		verify(paymentRepository,times(1)).findById(2L);
	}
	
	@Test
	public void updatePaymentTest() {
		when(paymentRepository.save(payment)).thenReturn(payment);
		assertEquals(payment, paymentService.updatePayment(1L,payment));
		verify(paymentRepository,times(1)).save(payment);
	}
	
	@AfterEach
	public void tearDown() {
		payment=null;
		card=null;
	}
	
	
}
