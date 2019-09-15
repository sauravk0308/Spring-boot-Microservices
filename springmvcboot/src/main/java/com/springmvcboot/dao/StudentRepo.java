package com.springmvcboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springmvcboot.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

	List<Student> findByFirstName(String name);
	List<Student> findByFirstNameOrderByFirstNameDesc(String name);
	
	@Query("from Student where firstName=:name")
	List<Student> find(@Param("name")String name);
}
