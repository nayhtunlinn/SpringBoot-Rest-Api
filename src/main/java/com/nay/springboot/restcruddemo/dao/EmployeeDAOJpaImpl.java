package com.nay.springboot.restcruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nay.springboot.restcruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
		List<Employee> emps = query.getResultList();
		return emps;
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		Employee emp=entityManager.find(Employee.class, id);
		return emp;
	}

	@Override
	public Employee save(Employee emp) {
		// TODO Auto-generated method stub
		Employee employee=entityManager.merge(emp);
		return employee;
	}

	@Override
	public void deleteByID(int id) {
		
		Employee emp=entityManager.find(Employee.class,id);
		entityManager.remove(emp);
		
	}

}
