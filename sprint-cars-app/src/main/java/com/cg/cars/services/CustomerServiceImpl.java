package com.cg.cars.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.cars.models.Customer;
import com.cg.cars.models.Payment;
import com.cg.cars.repositories.ICustomerRepository;

public class CustomerServiceImpl implements ICustomerService 
{
	@Autowired
	ICustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		
		return null;
	}

	@Override
	public Customer removeCustomer(long custId) {
		
		Customer customer= customerRepository.findById(custId).get();
		customerRepository.deleteById(custId);
		return customer;
		
		
	}

	@Override
	public Customer updateCustomer(long custId, Customer customer) {
		
		customerRepository.save(customer);
		return customer;
	}

	@Override
	public Customer getCustomer(long custId) {
		
		return customerRepository.findById(custId).get();
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> customers=new ArrayList<>();
		customerRepository.findAll().forEach(p -> customers.add(p));
		return customers;
	}

	@Override
	public List<Customer> getCustomersByCity(String city) {
		
		return customerRepository.findByCity(city);
		
	}
	
	@Override
	public List<Customer> getCustomersByState(String state) {
		
		return customerRepository.findByState(state);
		
	}

}
