package com.kevinpham.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevinpham.springdemo.entity.Customer;
import com.kevinpham.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// autowire the CusomterService
	@Autowired
	private CustomerService customerService;

	
	// mapping for GET /customers -> Get all customers
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		
		// delegate the task to CustomerService
		return customerService.getCustomers();
	}

	
	// mapping for GET /customer/{customerId} -> Get a single customer by their ID
	@GetMapping("/customers/{customerId}")
	public Customer getCustomers(@PathVariable int customerId) {
		
		// delegate the task to CustomerService
		Customer theCustomer = customerService.getCustomer(customerId);
		
		return theCustomer;
	}
	
}
