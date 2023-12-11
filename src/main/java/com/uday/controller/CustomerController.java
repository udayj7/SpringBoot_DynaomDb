package com.uday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.uday.entity.Customer;
import com.uday.repository.CustomerRepository;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/add/customer")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerRepository.saveCustomer(customer);
    }

    @GetMapping("/get/customer/{id}")
    public Customer getCustomerById(@PathVariable("id") String customerId) {
        return customerRepository.getCustomerById(customerId);
    }
    
    @GetMapping("/get")
    public PaginatedScanList<Customer> getAllCustomer() {
    	return customerRepository.getCustomeAll();
    }

    @DeleteMapping("/delete/customer/{id}")
    public String deleteCustomerById(@PathVariable("id") String customerId) {
        return  customerRepository.deleteCustomerById(customerId);
    }

    @PutMapping("/update/customer/{id}")
    public String updateCustomer(@PathVariable("id") String customerId, @RequestBody Customer customer) {
        return customerRepository.updateCustomer(customerId,customer);
    }
}
