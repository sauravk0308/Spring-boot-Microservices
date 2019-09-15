package com.springDemo.SpringDemo;

public class Alian {

	private int age;
	private Computer com;
	
	public Alian() {
		System.out.println("Alian Constructor");
	}
	
	/*public Alian(int age) {
		this.age = age;
	}
	
	*/
	public Computer getCom() {
		return com;
	}


	public void setCom(Computer com) {
		this.com = com;
	}


	public void code() {
		System.out.println("This is just for testing");
		com.compile();
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		System.out.println("age assigned");
		this.age = age;
	}
	
	
}
