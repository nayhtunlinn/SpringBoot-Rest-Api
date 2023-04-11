package com.nay.springboot.restcruddemo.rest;

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

import com.nay.springboot.restcruddemo.entity.Customer;
import com.nay.springboot.restcruddemo.service.CustomerService;

@RestController
@RequestMapping("/cApi")
public class CustomerRestController {
	
	private CustomerService customerService;

	@Autowired
	public CustomerRestController(CustomerService customerService) {
		this.customerService = customerService;
	}
	@GetMapping("/customers")
	public List<Customer> findAll() {
		return customerService.findAll();
	}

	@GetMapping("/customers/{customerId}")
	public Customer findByID(@PathVariable int customerId) {
		System.out.println(customerId);
		Customer c=customerService.findByID(customerId);
		System.out.println(c);
		if(c==null) {
			throw new RuntimeException("Customer id not found - "+customerId);
		}
		return c;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.save(customer);
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomerById(@PathVariable int customerId) {
		Customer c=customerService.findByID(customerId);
		if(c==null) {
			throw new RuntimeException("Customer id not found - "+customerId);
		}
		customerService.deleteByID(customerId);
		return "Deleted customer id - "+customerId;
	}
}
