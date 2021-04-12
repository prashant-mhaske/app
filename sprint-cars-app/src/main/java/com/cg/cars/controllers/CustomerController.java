package com.cg.cars.controllers;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.cg.cars.models.Customer;
import com.cg.cars.services.CustomerService;
 
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer c=customerService.addCustomer(customer);
        return new ResponseEntity<Customer>(c, HttpStatus.OK);
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity<Customer> removeCustomer(@PathVariable("id") long id){
        Customer c=customerService.removeCustomer(id);
        return new ResponseEntity<Customer>(c,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        Customer c=customerService.updateCustomer(0, customer);
        return new ResponseEntity<Customer>(c, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id) {
        Customer c=customerService.getCustomer(id);
        return new ResponseEntity<Customer>(c, HttpStatus.OK);
    }

    @GetMapping("/get")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/get/{state}")
    public List<Customer> getCustomersByState(String state){

        return customerService.getCustomersByState(state);
    }

    @GetMapping("/get/{city}")
    public List<Customer> getCustomersByCity(String city){

        return customerService.getCustomersByState(city);
    }
 
}