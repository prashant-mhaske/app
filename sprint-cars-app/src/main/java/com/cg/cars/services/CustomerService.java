package com.cg.cars.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.exceptions.CustomerNotFoundException;
import com.cg.cars.models.Customer;
import com.cg.cars.repositories.ICustomerRepository;

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

@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	ICustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer removeCustomer(long custId) {
		Customer customer=getCustomer(custId);
		customerRepository.deleteById(custId);
		return customer;
	}

	@Override
	public Customer updateCustomer(long custId, Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomer(long custId) {
		return customerRepository.findById(custId).orElseThrow(() -> new CustomerNotFoundException("Customer details not found!"));
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers=new ArrayList<>();
		customerRepository.findAll().forEach(c ->customers.add(c));
		return customers;
	}

	@Override
	public List<Customer> getCustomersByCity(String city) {
		return null;
	}

	@Override
	public List<Customer> getCustomersByState(String state) {
		return null;
	}
	

}
