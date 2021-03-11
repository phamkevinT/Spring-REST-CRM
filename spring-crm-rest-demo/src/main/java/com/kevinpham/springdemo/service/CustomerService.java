package com.kevinpham.springdemo.service;

/**
 * 
 * 		Customer Service talks to our backend, Customer DAO
 * 			- Delegates calls from Customer Service to Customer DAO
 */

import java.util.List;

import com.kevinpham.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
