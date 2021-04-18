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
	
	@PostMapping("/add/{id}/{billingDate}/{userId}")
	public ResponseEntity<Order> addOrder(@PathVariable("id") long id, @RequestParam("billingDate") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate billingDate, @PathVariable("userId") long custId, @RequestBody List<Long> carId) {
		return new ResponseEntity<>(orderService.addOrder(id, billingDate, custId, carId), HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Order> removeOrder(@PathVariable("id") long id) {
		return new ResponseEntity<>(orderService.removeOrder(id), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}/{billingDate}/{userId}")
	public ResponseEntity<Order> updateOrder(@PathVariable("id") long id, @RequestParam("billingDate") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate billingDate, @PathVariable("userId") long custId, @RequestBody List<Long> carId){	//NOSONAR
		return new ResponseEntity<>(orderService.updateOrder(id, billingDate, custId, carId), HttpStatus.OK);
	}
	
	@GetMapping("/getOrderDetails/{id}")
	public ResponseEntity<Order> getOrderDetails(@PathVariable("id") long id) {
		return new ResponseEntity<>(orderService.getOrderDetails(id), HttpStatus.OK);
	}
	
	@GetMapping("/GetCars/billDate/{billingDate}")
	private ResponseEntity<List<Order>> getOrdersByBillingDate(@RequestParam("billingDate") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate billingDate) {
		return new ResponseEntity<List<Order>>(orderService.getOrdersByBillDate(billingDate), HttpStatus.OK);
	}
	
	@GetMapping("/getAllOrders")
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	@GetMapping("/getBill/{id}")
	public ResponseEntity<String> getBill(@PathVariable("id") long id){
		return new ResponseEntity<>(orderService.getBill(id), HttpStatus.OK); 
	}
}