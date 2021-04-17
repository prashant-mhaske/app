package com.cg.cars.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.exceptions.OrderNotFoundException;
import com.cg.cars.models.Customer;
import com.cg.cars.models.Order;
import com.cg.cars.repositories.IOrderRepository;

@Service
public class OrderService implements IOrderService {

	@Autowired
	IOrderRepository orderRepository;
	
	@Autowired
	CustomerService customerService;
	
	@Override
	public Order addOrder(long id, double amount, LocalDate billingDate, long custId) {
		Customer customer = customerService.getCustomer(custId);
		Order order = new Order(id, amount, billingDate, customer);  
		return orderRepository.save(order);
	}
	
	public Order addOrder(Order order) {
		return orderRepository.save(order);
	}
	
	@Override
	public Order removeOrder(long id) {
		Order order = getOrderDetails(id);
		orderRepository.deleteById(id);
		return order;
	}
	
	@Override
	public Order updateOrder(long id, Order order) {
		orderRepository.save(order);
		return order;
	}

	@Override
	public Order getOrderDetails(long id) throws OrderNotFoundException {
		return orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("No such Order found"));
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> order = new ArrayList<>();
		orderRepository.findAll().forEach(o -> order.add(o));
		return order;
	}
}