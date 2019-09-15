package com.springboot.demo.thymeleafdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.thymeleafdemo.dao.EmployeeRepository;
import com.springboot.demo.thymeleafdemo.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int theId) {
		Employee theEmployee = employeeRepository.findOne(theId);
		
		if(theEmployee != null) {
			return theEmployee;
		}else {
			throw new RuntimeException("Did not find employee id "+theId);
		}
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.delete(theId);
	}

}
