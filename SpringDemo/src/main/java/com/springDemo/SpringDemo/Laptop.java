package com.springDemo.SpringDemo;

public class Laptop implements Computer{
	public Laptop() {
		System.out.println("Laptop Constructor");
	}
	
	public void compile() {
		System.out.println("code compiled in laptop");
	}
}
