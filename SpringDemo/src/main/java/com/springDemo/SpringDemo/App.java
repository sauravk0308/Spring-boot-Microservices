package com.springDemo.SpringDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
    	ApplicationContext context = new 	ClassPathXmlApplicationContext("spring.xml");
    	
    	Alian obj = (Alian)context.getBean("alian");
    	obj.code();
    	System.out.println(obj.getAge());
    }
}
