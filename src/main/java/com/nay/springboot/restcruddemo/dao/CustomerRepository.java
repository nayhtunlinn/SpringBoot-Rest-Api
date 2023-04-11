package com.nay.springboot.restcruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nay.springboot.restcruddemo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
