package com.nay.springboot.restcruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nay.springboot.restcruddemo.dao.EmployeeDAO;
import com.nay.springboot.restcruddemo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceJpaImpl implements EmployeeService {
	
	private EmployeeDAO employeeDao;
	
	@Autowired
	public EmployeeServiceJpaImpl(EmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployee();
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.findById(id);
	}

	@Override
	@Transactional
	public Employee save(Employee emp) {
		// TODO Auto-generated method stub
		return employeeDao.save(emp);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		employeeDao.deleteByID(id);
	}

}
