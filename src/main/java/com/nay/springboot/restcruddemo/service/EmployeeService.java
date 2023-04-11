package com.nay.springboot.restcruddemo.service;

import java.util.List;

import com.nay.springboot.restcruddemo.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	
	Employee findById(int id);
	
	Employee save(Employee emp);
	
	void deleteById(int id);
}
