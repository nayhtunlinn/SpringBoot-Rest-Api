package com.nay.springboot.restcruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nay.springboot.restcruddemo.dao.CustomerRepository;
import com.nay.springboot.restcruddemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer findByID(int id) {
		// TODO Auto-generated method stub
		Optional<Customer> c= customerRepository.findById(id);
		Customer customer=null;
		if(c.isPresent()) {
			customer=c.get();
		}else {
			throw new RuntimeException("Customer id not found - "+id);
		}
		
		return customer;
	}

	@Override
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public void deleteByID(int id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);
	}

}
