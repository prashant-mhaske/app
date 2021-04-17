package com.cg.cars.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cg.cars.models.Customer;

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

public interface ICustomerRepository extends CrudRepository<Customer, Long> {

//	public Customer addCustomer(Customer customer);
//	public Customer removeCustomer(long custId);
//	public Customer updateCustomer(long custId, Customer customer);
//	public Customer getCustomer(long custId);
//	public List<Customer> getAllCustomers(); 
//	public List<Customer> getCustomersByLocation();
	
//	@Query("select c from Customer c where c.city = ?1")
//	public List<Customer> findByCity(@Param(value = "city") String city);
//	
//	@Query("select c from Customer c where c.state = ?1")
//	public List<Customer> findByState(@Param(value = "state") String state);
	
	
}
