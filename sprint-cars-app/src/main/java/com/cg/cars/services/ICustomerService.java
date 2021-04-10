package com.cg.cars.services;

import java.util.List;

import com.cg.cars.models.Customer;

public interface ICustomerService {

	public Customer addCustomer(Customer customer);
	public Customer removeCustomer(long custId);
	public Customer updateCustomer(long custId, Customer customer);
	public Customer getCustomer(long custId);
	public List<Customer> getAllCustomers(); 
	public List<Customer> getCustomersByCity(String city);
	public List<Customer> getCustomersByState(String state);
}
