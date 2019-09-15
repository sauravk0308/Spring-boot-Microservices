package com.springboot.demo.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.demo.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private List<Employee> theEmployees;
	
	@PostConstruct
	public void loadDat() {
		Employee emp1 = new Employee(1, "AA", "BB", "aa@mail.com");
		Employee emp2 = new Employee(2, "CC", "DD", "cc@mail.com");
		Employee emp3 = new Employee(13, "EE", "FF", "ee@mail.com");
		
		
		theEmployees = new ArrayList<>();
		
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		theModel.addAttribute("employees", theEmployees);
		return "list-employees";
	}
}
