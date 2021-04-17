package com.cg.cars.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.cars.exceptions.InvalidPasswordException;
import com.cg.cars.exceptions.UserNotFoundException;
import com.cg.cars.models.Address;
import com.cg.cars.models.Customer;
import com.cg.cars.repositories.IUserRepository;
import com.cg.cars.services.UserService;

/**
*
* @author TEAM 2
* MEMBERS:	Abhishek Sen
* 			Prashant Mhaske
*			Rishabh Gupta
* 			Akshay Talekar
*			Nikhil Nichit
*
*/

@SpringBootTest
class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	@MockBean
	IUserRepository userRepository;
	
	Address address;
	Customer customer;
	
	@BeforeEach
	void init() {
		
		address=new Address();
		customer=new Customer();
		address.setDoorNo(12);
		address.setArea("City Area");
		address.setCity("Pune");
		address.setPincode(300087);
		address.setState("MH");
		address.setStreet("ABC Street");
		
		customer.setUserId(1L);
		customer.setName("Mr X");
		customer.setEmail("abc@mail.com");
		customer.setPassword("pass");
		customer.setDob(LocalDate.of(1994, 05, 12));
		customer.setContactNo("9765456798");
		customer.setAddress(address);
		customer.setRole("Customer");
	}
	
	@Test
	void testSignIn() {
		when(userRepository.findById(1L)).thenReturn(Optional.of(customer));
		assertEquals(customer, userService.signIn(1L, "pass"));
		assertTrue(customer.isLoggedIn);
		verify(userRepository,times(1)).findById(1L);
	}
	
	@Test
	void testInvalidPasswordException(){
		when(userRepository.findById(1L)).thenReturn(Optional.of(customer));
		assertThrows(InvalidPasswordException.class, () ->userService.signIn(1L, "wrongpass"));
	}
	
	@Test
	void testUserNotFoundException() {
		when(userRepository.findById(2L)).thenThrow(UserNotFoundException.class);
		assertThrows(UserNotFoundException.class, () ->userService.signIn(2L, "pass"));
		assertFalse(customer.isLoggedIn);
	}
	
	@Test
	void testSignOut() {
		when(userRepository.findById(1L)).thenReturn(Optional.of(customer));
		userService.signIn(1L, "pass");
		userService.signOut(customer);
		assertFalse(customer.isLoggedIn);
	}
	
	@Test
	void testChangePassword() {
		when(userRepository.findById(1L)).thenReturn(Optional.of(customer));
		when(userRepository.save(customer)).thenReturn(customer);
		assertEquals(customer, userService.changePassword(1L, customer));
		verify(userRepository,times(1)).save(customer);
	}
}
