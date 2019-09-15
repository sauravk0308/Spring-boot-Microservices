package com.springmvcboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springmvcboot.dao.StudentRepo;
import com.springmvcboot.model.Student;

//@Controller
@RestController
public class HomeController {

	@Autowired
	private StudentRepo studentRepo;
	
	@GetMapping(path="students", produces= {"application/xml"})
//	/@ResponseBody
	public List<Student> getAllStudents()
	{
		return studentRepo.findAll();
	}
	
	/*@GetMapping("students/{studentId}")
	@ResponseBody
	public Student getStudents(@PathVariable("studentId") int studentId)
	{
		return studentRepo.findOne(studentId);
	}*/
	
	@GetMapping("students/{studentId}")
	public Student getStudents(@PathVariable("studentId") int studentId)
	{
		return studentRepo.findOne(studentId);
	}
	
	@PostMapping(path = "addStudent", consumes= {"application/json"})
	public Student addStudents(@RequestBody Student student)
	{
		System.out.println(student.getFirstName());
		return studentRepo.save(student);
	}
}
