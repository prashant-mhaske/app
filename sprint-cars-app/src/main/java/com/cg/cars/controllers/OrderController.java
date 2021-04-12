package com.cg.cars.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.cars.models.Order;
import com.cg.cars.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/add")
	public ResponseEntity<Order> addOrder(@RequestBody Order order){
		Order o = orderService.addOrder(order);
		return new ResponseEntity<>(o, HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Order> removeOrder(@PathVariable("id") long id) {
		Order o = orderService.removeOrder(id);
		return new ResponseEntity<>(o, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable("id") long id, Order order){
		Order o = orderService.updateOrder(id, order);
		return new ResponseEntity<>(o, HttpStatus.OK);
	}
	
	@GetMapping("/getOrderDetails/{id}")
	public ResponseEntity<Order> getOrderDetails(@PathVariable("id") long id) {
		Order o = orderService.getOrderDetails(id);
		return new ResponseEntity<>(o, HttpStatus.OK);
	}
	
	@GetMapping("/getAllOrders")
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
	}
}