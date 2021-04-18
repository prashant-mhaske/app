package com.cg.cars.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

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

public interface IOrderRepository extends CrudRepository<Order, Long>{
//	public Order addOrder(Order order);
//	public Order removeOrder(long id);
//	public Order updateOrder(long id, Order order);
//	public Order getOrderDetails(long id);
//	public List<Order> getAllOrders(); 
	@Query("Select o from Order o where billing_date = :billDate")
	public List<Order> findByDate(@Param(value = "billDate") LocalDate billingDate);
}