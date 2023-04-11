package com.nay.springboot.restcruddemo.service;

import java.util.List;

import com.nay.springboot.restcruddemo.entity.Customer;

public interface CustomerService {
	
	List<Customer> findAll();
	
	Customer findByID(int id);
	
	Customer save(Customer customer);
	
	Customer updateCustomer(Customer customer);
	
	void deleteByID(int id);

}
