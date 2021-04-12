package com.cg.cars.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.exceptions.CustomerNotFoundException;
import com.cg.cars.models.Customer;
import com.cg.cars.models.Payment;
import com.cg.cars.repositories.IAddressRepository;
import com.cg.cars.repositories.ICustomerRepository;

@Service
public class CustomerService implements ICustomerService {
	@Autowired
	ICustomerRepository customerRepository;

	@Autowired
	IAddressRepository addressRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		
		if(customer == null)
		{
			throw new CustomerNotFoundException("Customer not found!!");
		}
		
		else
		{
			return customerRepository.save(customer);
		}
	}

	@Override
	public Customer removeCustomer(long custId)  {

		Customer customer = getCustomer(custId);
		// customerRepository.findById(custId).get();
		customerRepository.deleteById(custId);
		return customer;

	}

	@Override
	public Customer updateCustomer(long custId, Customer customer) {
		if (customerRepository.findById(custId).isPresent()) {
			return customerRepository.save(customer);
		}

		else
			return null;
	}

	@Override
	public Customer getCustomer(long custId)  {

		return customerRepository.findById(custId)
				.orElseThrow(() -> new CustomerNotFoundException("Customer details not found"));
	}

	@Override
	public List<Customer> getAllCustomers()  {

		List<Customer> customers = new ArrayList<>();
		customerRepository.findAll().forEach(p -> customers.add(p));
		return customers;
	}

	@Override
	public List<Customer> getCustomersByCity(String city) {
		
		
		return addressRepository.findByCity(city);

	}

	@Override
	public List<Customer> getCustomersByState(String state) {

		return addressRepository.findByState(state);

	}

}
