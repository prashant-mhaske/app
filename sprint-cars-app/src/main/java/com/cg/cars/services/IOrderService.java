package com.cg.cars.services;

import java.time.LocalDate;
import java.util.List;

import com.cg.cars.models.Order;

public interface IOrderService {
	public Order addOrder(double amount, LocalDate billingDate, long id);
	public Order removeOrder(long id);
	public Order  updateOrder(long id, Order order);
	public Order  getOrderDetails(long id);
	public List<Order> getAllOrders(); 

}
