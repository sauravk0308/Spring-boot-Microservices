package com.springboot.demo.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.demo.cruddemo.entity.Employee;

@Transactional
@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{

	@Autowired
	private EntityManager entityManager;	
	
	
	@Override  
	public List<Employee> findAll() {

		// create a query
		List<Employee> employees =
				(List<Employee>) entityManager.createQuery("from Employee", Employee.class).getResultList();
		
		System.out.println("employees "+employees);
		// return the results		
		return employees;
	}

	@Override
	public Employee findById(int theId) {

		// get the employee
		Employee theEmployee =
				entityManager.find(Employee.class, theId);
		
		// return the employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {

		// save employee
		entityManager.merge(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		
		
		Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", theId);
		
		query.executeUpdate();
	}

}
