package com.rest.webservices.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value= {"name", "message"})
public class HelloWorldBean {

	private String message;
	//@JsonIgnore
	private String name;

	public HelloWorldBean(String message, String name) {
		super();
		this.message = message;
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + ", name=" + name + "]";
	}

	
}
