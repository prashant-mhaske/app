package com.cg.cars.services;

import java.util.List;

import com.cg.cars.models.Address;
import com.cg.cars.models.Customer;

public interface ICustomerService {

	public Customer addCustomer(Customer customer);
	public Customer removeCustomer(long custId);
	public Customer updateCustomer(long custId, Customer customer);
	public Customer getCustomer(long custId);
	public List<Customer> getAllCustomers();
	List<Customer> getCustomersByCity(String city);
	List<Customer> getCustomersByState(String state); 
	
}
