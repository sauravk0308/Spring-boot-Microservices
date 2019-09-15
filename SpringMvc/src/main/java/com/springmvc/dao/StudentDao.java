package com.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.model.Student;

@Component
public class StudentDao {

	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Student> getUsers(){
		
		Session session = sessionFactory.openSession();
		List<Student> students = session.createQuery("from student", Student.class).list();
		return students;
	}
	
}
