package com.rest.webservices.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rest.webservices.bean.User;

@Component
public class UserService {

	private static List<User> users = new ArrayList<>();
	private static int usersCount = 3;
	
	{
		/*users.add(new User(1, "Saurav", new Date()));
		users.add(new User(2, "Arvind", new Date()));
		users.add(new User(3, "Ajay", new Date()));*/
		users.add(new User(1, "Saurav"));
		users.add(new User(2, "Arvind"));
		users.add(new User(3, "Ajay"));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user){
		if(user.getId()==null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
} 
