package com.learning.jpa.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.learning.jpa.entity.User;

public class UserDaoServiceCommandLineRunner implements CommandLineRunner {

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);
	@Autowired
	private UserDAOService userDaoService;
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("Saurav", "Admin");
		long inertId = userDaoService.insert(user);
		log.info("New User is created "+user);
	}

}
