package com.springDemo.SpringDemo;

public class Desktop implements Computer{
	public Desktop() {
		System.out.println("Desktop Constructor");
	}
	
	public void compile() {
		System.out.println("code compiled in Desktop");
	}
}