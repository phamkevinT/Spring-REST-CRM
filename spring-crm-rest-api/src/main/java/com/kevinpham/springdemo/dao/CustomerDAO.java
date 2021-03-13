package com.kevinpham.springdemo.dao;

/**
 * 
 * 		Customer Data Access Object used to access data from database
 * 			- Abstracts the retrieval of data from the database
 * 
 */

import java.util.List;

import com.kevinpham.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
