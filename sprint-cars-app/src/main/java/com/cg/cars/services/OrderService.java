package com.cg.cars.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.CannotCreateRecordException;
import org.springframework.stereotype.Service;

import com.cg.cars.exceptions.OrderNotFoundException;
import com.cg.cars.models.Car;
import com.cg.cars.models.Customer;
import com.cg.cars.models.Order;
import com.cg.cars.repositories.ICarRepository;
import com.cg.cars.repositories.IOrderRepository;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class OrderService implements IOrderService {

	@Autowired
	IOrderRepository orderRepository;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ICarServiceImpl carService;
	
	@Autowired
	ICarRepository carRepository;
	
	//@Autowired
	List<Car> car;
	
	double total;
	double gst;
	double billingAmount;
	String s;
	Order order;
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
	public List<Order> getOrdersByBillDate(LocalDate billingDate) {
		return orderRepository.findByDate(billingDate);
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> order = new ArrayList<>();
		orderRepository.findAll().forEach(o -> order.add(o));
		return order;
	}
	
	@Override
	public String getBill(long id) {

		Order order = orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("No such Order found"));
		car = order.getCar();
		
		car.forEach(c -> total += c.getPrice());
		gst = total * 0.18;
		billingAmount = total + gst; 
		
		s = "\nOrder Id: " + id + "\nBilling Date: " + order.getBillingDate() + "\n" + order.getCustomer().toString() + "\n";
		car.forEach(c -> s += c.toString() + "\n");
		s += "\nTotal: " + total + "\nGST: " + gst + "\nBilling Amount: " + billingAmount;
		total=0;
		gst=0;
		billingAmount=0;
		return s;
	}
}