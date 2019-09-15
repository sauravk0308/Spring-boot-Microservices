package com.jpalearning.JpaDemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	EntityManagerFactory ef = Persistence.createEntityManagerFactory("");
    	EntityManager em = ef.createEntityManager();
    }
}
