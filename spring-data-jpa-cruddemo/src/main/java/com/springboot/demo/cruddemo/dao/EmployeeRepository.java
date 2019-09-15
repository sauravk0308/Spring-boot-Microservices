package com.springboot.demo.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
