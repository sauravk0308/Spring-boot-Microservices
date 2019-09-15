package com.springboot.demo.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	
	public List<Employee> findAllByOrderByLastNameAsc();
}
