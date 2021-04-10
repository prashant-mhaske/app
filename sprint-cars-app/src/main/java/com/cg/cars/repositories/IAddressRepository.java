package com.cg.cars.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cg.cars.models.Address;
import com.cg.cars.models.Customer;

public interface IAddressRepository extends CrudRepository<Address, String> {
	
	public List<Customer> findByCity(String city);
	public List<Customer> findByState(String state);
}
