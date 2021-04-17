package com.cg.cars.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

import com.cg.cars.models.Address;
import com.cg.cars.models.Customer;
import com.cg.cars.models.Order;
import com.cg.cars.services.CustomerService;
import com.cg.cars.services.OrderService;
import com.cg.cars.repositories.ICustomerRepository;
import com.cg.cars.repositories.IOrderRepository;

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
class OrderServiceTest {

	@Autowired
	OrderService orderService;
	
	@Autowired
	CustomerService customerService;
	
	@MockBean
	IOrderRepository orderRepository;
	
	@MockBean
	ICustomerRepository customerRepository;
	
	Order order;
	Customer customer;
	Address address;
	long custId;
	
	@BeforeEach
	void init() {
//		customer = new Customer(101, "1234", "John", "john@cg.com", "9876543210", LocalDate.of(2000, 01, 01), new Address(1, "Main Street", "ABC", "NY", "New York", 10030));
//		order = new Order(11L, 30000, LocalDate.of(2020, 12, 12), customer);
	}
	
	@Test
	void testAddOrder() {
		when(orderRepository.save(order)).thenReturn(order);
		assertEquals(order, orderService.addOrder(order));	
		verify(orderRepository, times(1)).save(order);
	}
	
	@Test
	void testRemoveOrder() {
		when(orderRepository.findById(11L)).thenReturn(Optional.of(order));
		when(orderRepository.existsById(11L)).thenReturn(false);
		orderService.removeOrder(11L);
		verify(orderRepository, times(1)).deleteById(11L);
		assertFalse(orderRepository.existsById(11L));
	}
	
	@Test
	void testUpdateOrder() {
		when(orderRepository.save(order)).thenReturn(order);
		assertEquals(order, orderService.updateOrder(11L, order));
		verify(orderRepository, times(1)).save(order);
	}
	
	@Test
	void testGetById() {
		when(orderRepository.findById(11L)).thenReturn(Optional.of(order));
		assertEquals(order, orderService.getOrderDetails(11L));
		verify(orderRepository,times(1)).findById(11L);
		
	}
	
	@Test
	void testGetAllOrders() {
//		Order order2 = new Order(12, 20000, LocalDate.of(2020, 11, 12), new Customer(102, "1235", "David", "david@cg.com", "9876556789", LocalDate.of(2000, 02, 02), new Address(1, "Old Street", "AAA", "NY", "New York", 10031)));
//		Order order3 = new Order(13, 10000, LocalDate.of(2020, 12, 11), new Customer(103, "1236", "Smith", "smith@cg.com", "9999988888", LocalDate.of(2000, 03, 03), new Address(1, "Titanic Street", "BBB", "NY", "New York", 10032)));
		
//		List<Order> orders = new ArrayList<>();
//		orders.add(order);
//		orders.add(order2);
//		orders.add(order3);
//		
//		when(orderRepository.findAll()).thenReturn(Stream.of(order, order2, order3).collect(Collectors.toList()));
//		assertEquals(orders, orderService.getAllOrders());
//		verify(orderRepository,times(1)).findAll();
	}
	
	@AfterEach
	void dropDown() {
		order=null;
		customer=null;
	}
}
