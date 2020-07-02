package com.springmvcboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="first_Name")
	private String firstName;
	@Column(name="last_Name")
	private String lastName;
	@Column(name="email")
	private String email;
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Student() {
		
	}
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.firstName = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return firstName;
	}
	public void setName(String name) {
		this.firstName = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + firstName + "]";
	}
	
	
}