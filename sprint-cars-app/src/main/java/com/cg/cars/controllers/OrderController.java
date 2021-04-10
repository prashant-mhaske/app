package com.cg.cars.controllers;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import com.cg.cars.models.Order;
import com.cg.cars.services.OrderService;
import com.cg.cars.repositories.IOrderRepository;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	IOrderRepository orderRepository;
	
	
	
//	@GetMapping("/getOrderDetail/{id}")
//	public Order getOrderDetail(@PathVariable("id") long id) {
//		return orderService.getOrderDetails(id);
//	}
	
//	@GetMapping("/getAllOrder")
//	public List<Order> getAllOrder(){
//		return orderService.getAllOrders();
//	}
}