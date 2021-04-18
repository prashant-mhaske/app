package com.cg.cars.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.exceptions.OrderNotFoundException;
import com.cg.cars.models.Car;
import com.cg.cars.models.Customer;
import com.cg.cars.models.Order;
import com.cg.cars.repositories.ICarRepository;
import com.cg.cars.repositories.ICustomerRepository;
import com.cg.cars.repositories.IOrderRepository;


/**
*
* @author TEAM 2
* MEMBERS:	Abhishek Sen
* 			    Prashant Mhaske
*			      Rishabh Gupta
* 			    Akshay Talekar
*			      Nikhil Nichit
*
*/



@Service
public class OrderService implements IOrderService {

	@Autowired
	IOrderRepository orderRepository;
	
	@Autowired
	ICustomerRepository customerRepository; 
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ICarServiceImpl carService;
	
	@Autowired
	ICarRepository carRepository;
	Customer customer;
	List<Car> car;
	
	double total;
	double gst;
	double billingAmount;
	String s;
	Order order;
	
	/*
	 * Add order details in database.
	 */
	@Override
	public Order addOrder(long id, LocalDate billingDate, long custId, List<Long> carId) {
		Customer customer = customerService.getCustomer(custId);
		order=new Order();
		order.setId(id);
		order.setBillingDate(billingDate);
		order.setCustomer(customer);
		order=orderRepository.save(order);
		List<Car> cars=new ArrayList<>();
		carId.forEach(cId->{
			Car c=carService.getCarById(cId);
			cars.add(c);
			c.getOrder().add(order);
			carRepository.save(c);
		});
		order.setCar(cars);
		return orderRepository.save(order);
	}
	
	public Order addOrder(Order order) {
		return orderRepository.save(order);
	}
	
	/*
	 * Remove order details from database using order Id.
	 */
	@Override
	public Order removeOrder(long id) {
		Order order = getOrderDetails(id);
		orderRepository.deleteById(id);
		return order;
	}
	
	/*
	 * Update order details in database using order Id.
	 */
	@Override
	public Order updateOrder(long id, LocalDate billingDate, long custId, List<Long> carId) {
		order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("No such order Found"));
		order.setBillingDate(billingDate);
		customer = customerRepository.findById(custId).get();
		order.setCustomer(customer);
		List<Car> car = new ArrayList<>();
		carId.forEach(cId->{
			Car c=carService.getCarById(cId);
			if(order.getCar().contains(c)) {}
			else {
			car.add(c);
			c.getOrder().add(order);
			carRepository.save(c);
			}
		});
		order.setCar(car);
		return orderRepository.save(order);
	}

	/*
	 * Retrieving order details from database using order Id.
	 */
	@Override
	public Order getOrderDetails(long id) throws OrderNotFoundException {
		return orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("No such Order found"));
	}
	
	/*
	 * Retrieving order details from database using Billing Date.
	 */
	@Override
	public List<Order> getOrdersByBillDate(LocalDate billingDate) {
		return orderRepository.findByDate(billingDate);
	}

	/*
	 * Retrieving all order details from database.
	 */
	@Override
	public List<Order> getAllOrders() {
		List<Order> order = new ArrayList<>();
		orderRepository.findAll().forEach(o -> order.add(o));
		return order;
	}
	
	/*
	 * Calculating Order Bill using order Id.
	 */
	@Override
	public String getBill(long id) {
		Order order = orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("No such Order found"));
		car = order.getCar();
		car.forEach(c -> total += c.getPrice());
		gst = total * 0.18;
		billingAmount = total + gst; 
		s = "Order Id: " + id + "\nBilling Date: " + order.getBillingDate() + "\n" + order.getCustomer().toString() + "\n";
		car.forEach(c -> s += c.toString() + "\n");
		s += "\nTotal: " + total + "\nGST: " + gst + "\nBilling Amount: " + billingAmount;
		total=0;
		gst=0;
		billingAmount=0;
		return s;
	}
}