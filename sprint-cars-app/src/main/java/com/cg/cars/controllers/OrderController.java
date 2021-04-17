package com.cg.cars.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.cars.models.Order;
import com.cg.cars.services.OrderService;

@RestController
@RequestMapping("/Order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/add/{id}/{amount}/{billingDate}/{userId}")
	public ResponseEntity<Order> addOrder(@PathVariable("id") long id, @PathVariable("amount") double amount, @RequestParam("billingDate") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate billingDate, @PathVariable("userId") long custId){
		return new ResponseEntity<>(orderService.addOrder(id, amount, billingDate, custId), HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Order> removeOrder(@PathVariable("id") long id) {
		Order o = orderService.removeOrder(id);
		return new ResponseEntity<>(o, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable("id") long id, @RequestBody Order order){	//NOSONAR
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