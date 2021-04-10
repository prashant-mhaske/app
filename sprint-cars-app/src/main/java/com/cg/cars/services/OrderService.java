package com.cg.cars.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.models.Order;
import com.cg.cars.repositories.IOrderRepository;

@Service
public class OrderService implements IOrderService{

	@Autowired
	IOrderRepository orderRepository;
	
	@Override
	public Order addOrder(Order order) {
		return null;
	}
	
	@Override
	public Order removeOrder(long id) {
		Order order = orderRepository.findById(id).get();
		orderRepository.deleteById(id);
		return order;
	}
	
	@Override
	public Order updateOrder(long id, Order order) {
		orderRepository.save(order);
		return order;
	}

	@Override
	public Order getOrderDetails(long id) {
		Order order = orderRepository.findById(id).get();
		return order;
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> order = new ArrayList<>();
		orderRepository.findAll().forEach(o -> order.add(o));
		return order;
	}
}