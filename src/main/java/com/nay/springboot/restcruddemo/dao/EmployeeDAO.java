package com.nay.springboot.restcruddemo.dao;

import java.util.List;

import com.nay.springboot.restcruddemo.entity.Employee;

public interface EmployeeDAO {

	List<Employee> getAllEmployee();
	
	Employee findById(int id);
	
	Employee save(Employee emp);
	
	void deleteByID(int id);
}
