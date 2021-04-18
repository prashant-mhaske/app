package com.cg.cars.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.cars.exceptions.OrderNotFoundException;
import com.cg.cars.models.Address;
import com.cg.cars.models.Car;
import com.cg.cars.models.Customer;
import com.cg.cars.models.Order;
import com.cg.cars.services.CustomerService;
import com.cg.cars.services.ICarServiceImpl;
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
	
	@Autowired
	ICarServiceImpl carService;
	
	@MockBean
	IOrderRepository orderRepository;
	
	@MockBean
	ICustomerRepository customerRepository;
	
	Order order;
	Customer customer;
	Address address;
	
	List<Car> cars;
	double total=0;
	double gst=0;
	double billingAmount=0;
	long id;
	String s="";
	
	@BeforeEach
	void init() {
		customer=new Customer();
		order=new Order();
		customer.setUserId(101L);
		customer.setPassword("1234");
		customer.setName("John");
		customer.setEmail("john@cg.com");
		customer.setContactNo("9876543210");
		customer.setDob(LocalDate.of(2000, 01, 01));
		address = new Address();
		address.setDoorNo(1);
		address.setStreet("Main Street");
		address.setArea("ABC");
		address.setCity("NY");
		address.setState("New York");
		address.setPincode(10030);
		customer.setAddress(address);
		order.setId(11L);
		order.setBillingDate(LocalDate.of(2020, 12, 12));
		order.setCustomer(customer);
		Car c1=new Car();
		c1.setId(1L);;
		c1.setBrand("Ford");
		c1.setModel("Eco");
		c1.setColor("Orange");
		c1.setVariant("Vxi");
		c1.setPrice(18.5);
		c1.setRegistrationYear(LocalDate.of(2020, 01, 25));
		c1.setRegistrationState("Maharashtra");
		Car c2=new Car();
		c2.setId(2L);
		c2.setBrand("Kia");
		c2.setModel("Seltos");
		c2.setColor("White");
		c2.setVariant("Old");
		c2.setPrice(9.5);
		c2.setRegistrationYear(LocalDate.of(2020, 02, 20));
		c2.setRegistrationState("Maharashtra");
		List<Car> car = Arrays.asList(c1, c2);
		order.setCar(car);
	}

	@Test
	@DisplayName("Test to check whether Order is added")
	void addOrderTest() {
		when(orderRepository.save(order)).thenReturn(order);
		assertEquals(order, orderService.addOrder(order));	
		verify(orderRepository, times(1)).save(order);
	}
	
	@Test
	@DisplayName("Test to check whether Order is deleted")
	void removeOrderTest() {
		when(orderRepository.findById(11L)).thenReturn(Optional.of(order));
		when(orderRepository.save(order)).thenReturn(order);
		orderService.removeOrder(11L);
		verify(orderRepository, times(1)).save(order);
	}
	
	@Test
	@DisplayName("Test to check whether Order is not deleted")
	void removeOrderNegativeTest() {
		when(orderRepository.findById(12L)).thenThrow(OrderNotFoundException.class);
		assertThrows(OrderNotFoundException.class, () -> orderService.removeOrder(12L));
		verify(orderRepository,times(0)).deleteById(12L);
		verify(orderRepository,times(1)).findById(12L);
	}
	
	@Test
	@DisplayName("Test to check whether Order is updated")
	void updateOrderTest() {
		List<Long> carId = Arrays.asList(1L, 2L);
		when(orderRepository.save(order)).thenReturn(order);
		assertThrows(OrderNotFoundException.class, () -> orderService.updateOrder(order.getId(), order.getBillingDate(), customer.getUserId(), carId));
		verify(orderRepository, times(1)).findById(order.getId());
	}
	
	@Test
	@DisplayName("Test to check whether Order is available on Order Id")
	void getOrderByIdTest() {
		when(orderRepository.findById(11L)).thenReturn(Optional.of(order));
		assertEquals(order, orderService.getOrderDetails(11L));
		verify(orderRepository,times(1)).findById(11L);
	}
	
	@Test
	@DisplayName("Test to check whether Order is not available on Order Id")
	void getOrderByIdNegativeTest() {
		when(orderRepository.findById(12L)).thenThrow(OrderNotFoundException.class);
		assertThrows(OrderNotFoundException.class, () -> orderService.getOrderDetails(12L));
		verify(orderRepository,times(1)).findById(12L);
	}
	
	@Test
	@DisplayName("Test to check whether Orders are available on Billing Date")
	void getOrdersByBillingDateTest() {
		Car car1 = new Car(103, "Ford", "Safari", "Black", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");
		Car car2 = new Car(104, "Ford", "Eco", "Black", "Vxi", 15.5, LocalDate.of(2016, 03, 15), "Maharashtra");
		List<Car> cars = Arrays.asList(car1, car2);
		Order order2 = new Order(12, LocalDate.of(2020, 02, 20), new Customer(102, "1235", "David", "david@cg.com", "9876556789", LocalDate.of(2000, 02, 02), new Address(1, "Old Street", "AAA", "NY", "New York", 10031)), cars);
		Order order3 = new Order(13, LocalDate.of(2019, 12, 11), new Customer(103, "1236", "Smith", "smith@cg.com", "9999988888", LocalDate.of(2000, 03, 03), new Address(1, "Titanic Street", "BBB", "NY", "New York", 10032)), cars);
		
		List<Order> orders = new ArrayList<>();
		orders.add(order);
		orders.add(order2);
		orders.add(order3);
		when(orderRepository.findByDate(LocalDate.of(2020, 02, 20))).thenReturn(Stream.of(order, order2, order3).collect(Collectors.toList()));
		assertEquals(orders, orderService.getOrdersByBillDate(LocalDate.of(2020, 02, 20)));
		verify(orderRepository, times(1)).findByDate(LocalDate.of(2020, 02, 20));
	}

	@Test
	@DisplayName("Test to check Orders are not available on Billing Date")
	void getOrdersByBillingDateNegativeTest() {
		when(orderRepository.findByDate(LocalDate.of(2020, 12, 12))).thenThrow(OrderNotFoundException.class);
		assertThrows(OrderNotFoundException.class, () -> orderService.getOrdersByBillDate(LocalDate.of(2020, 12, 12)));
		verify(orderRepository, times(1)).findByDate(LocalDate.of(2020, 12, 12));
	}
	
	@Test
	@DisplayName("Test to check whether all records are accessible")
	void getAllOrdersTest() {
		Car car1 = new Car(103, "Ford", "Safari", "Black", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");
		Car car2 = new Car(104, "Ford", "Eco", "Black", "Vxi", 15.5, LocalDate.of(2016, 03, 15), "Maharashtra");
		List<Car> cars = Arrays.asList(car1, car2);
		Order order2 = new Order(12L, LocalDate.of(2020, 11, 12), new Customer(102, "1235", "David", "david@cg.com", "9876556789", LocalDate.of(2000, 02, 02), new Address(1, "Old Street", "AAA", "NY", "New York", 10031)), cars);
		Order order3 = new Order(13L, LocalDate.of(2020, 12, 11), new Customer(103, "1236", "Smith", "smith@cg.com", "9999988888", LocalDate.of(2000, 03, 03), new Address(1, "Titanic Street", "BBB", "NY", "New York", 10032)), cars);
		
		List<Order> orders = new ArrayList<>();
		orders.add(order);
		orders.add(order2);
		orders.add(order3);
		
		when(orderRepository.findAll()).thenReturn(Stream.of(order, order2, order3).collect(Collectors.toList()));
		assertEquals(orders, orderService.getAllOrders());
		verify(orderRepository,times(1)).findAll();
	}
	
	@Test
	@DisplayName("Test to check whether Order Bill is generated")
	void getBillTest() {
		when(orderRepository.findById(11L)).thenReturn(Optional.of(order));
		id = order.getId();
		cars = order.getCar();
		cars.forEach(c -> total += c.getPrice());
		gst = total * 0.18;
		billingAmount = total + gst; 
		s = "Order Id: " + id + "\nBilling Date: " + order.getBillingDate() + "\n" + order.getCustomer().toString() + "\n";
		cars.forEach(c -> s += c.toString() + "\n");
		s += "\nTotal: " + total + "\nGST: " + gst + "\nBilling Amount: " + billingAmount;
		assertEquals(s, orderService.getBill(11L));
		verify(orderRepository,times(1)).findById(11L);
	}
	
	@AfterEach
	void dropDown() {
		order=null;
		customer=null;
	}
}
