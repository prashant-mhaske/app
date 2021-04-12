package com.cg.cars.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cg.cars.models.Customer;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {

//	public Customer addCustomer(Customer customer);
//	public Customer removeCustomer(long custId);
//	public Customer updateCustomer(long custId, Customer customer);
//	public Customer getCustomer(long custId);
//	public List<Customer> getAllCustomers(); 
//	public List<Customer> getCustomersByLocation();
	
	
}
