package com.kevinpham.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevinpham.springdemo.entity.Customer;
import com.kevinpham.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// autowire the CustomerService
	@Autowired
	private CustomerService customerService;

	/**
	 * mapping for GET /customers -> Get all customers
	 * 
	 * @return delegate task to CustomerService and return customer
	 */
	@GetMapping("/customers")
	public List<Customer> getCustomers() {

		// delegate the task to CustomerService
		return customerService.getCustomers();
	}

	/**
	 * mapping for GET /customer/{customerId} -> Get a single customer by their ID
	 * 
	 * @param customerId the customer's ID
	 * @return the customer from database
	 */
	@GetMapping("/customers/{customerId}")
	public Customer getCustomers(@PathVariable int customerId) {

		// delegate the task to CustomerService
		Customer theCustomer = customerService.getCustomer(customerId);

		// Jackson will return null JSON if not found.
		// If so, throw an exception
		if (theCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		}

		return theCustomer;
	}

	/**
	 * mapping for POST /customers -> Add new customer
	 * 
	 * @param theCustomer the customer to be added
	 * @return delegate task to CustomerService and return customer
	 */
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {

		// Just in case user pass an ID in JSON ... set ID to 0
		// This forces a save of new item ... instead of updating
		theCustomer.setId(0);

		// Use @RequestBody to access the request body as a POJO and delegate call to
		// CustomerService
		customerService.saveCustomer(theCustomer);

		return theCustomer;
	}

	/**
	 * mapping for PUT /customers -> Update an existing customer
	 * 
	 * @param theCustomer the customer who's information is to be updated
	 * @return delegate task to CustomerService and return customer
	 */
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {

		// Delegate call to CustomerService
		customerService.saveCustomer(theCustomer);

		return theCustomer;
	}

	/**
	 * mapping for DELETE /customers -> Delete an existing customer
	 * 
	 * @param customerId the ID of customer to be deleted
	 * @return delegate task to CustomerService and return customer
	 */
	@DeleteMapping("customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {

		// Used to check if customer exists
		Customer tempCustomer = customerService.getCustomer(customerId);

		// Throw exception if customer does not exists
		if (tempCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		}

		// Delegate call to CustomerService
		customerService.deleteCustomer(customerId);

		return "Deleted customer id - " + customerId;
	}

}
