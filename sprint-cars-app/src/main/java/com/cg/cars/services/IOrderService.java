package com.cg.cars.services;

import java.time.LocalDate;
import java.util.List;

import com.cg.cars.models.Order;

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

public interface IOrderService {
	public Order addOrder(long id, double amount, LocalDate billingDate, long custid);
	public Order removeOrder(long id);
	public Order  updateOrder(long id, Order order);
	public Order  getOrderDetails(long id);
	public List<Order> getAllOrders(); 

}
