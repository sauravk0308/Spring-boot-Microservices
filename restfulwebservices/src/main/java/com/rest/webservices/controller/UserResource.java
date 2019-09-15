package com.rest.webservices.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservices.bean.User;
import com.rest.webservices.exception.UserNotFoundException;
import com.rest.webservices.repository.UserRepository;
import com.rest.webservices.service.UserService;

@RestController
public class UserResource {

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		//return userService.findAll();
		return userRepo.findAll();
	}
	/*
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id){
		User user = userService.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id "+id);
		}
		
		return user;
	}*/
	
	@GetMapping("/users/{id}")
	//public ResponseEntity<Resource<User>> retrieveUser(@PathVariable int id){
	public Resource<User> retrieveUser(@PathVariable int id){
		User user = userService.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id "+id);
		}
		
		// "all-users" SERVER_PATH +"+/path"
		// retrieveAllUsers
		
		final Resource<User> resource = new Resource<User>(user);
	   /* 
	    final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
	    System.out.println("uriString "+uriString);
	    resource.add(new Link(uriString, "all-users"));
	    */
	    
	    ControllerLinkBuilder linkTo = ControllerLinkBuilder
                .linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
	    
	    resource.add(linkTo.withRel("all-users"));
	    
	    //return ResponseEntity.ok(resource);
	    return resource;
		    
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
		User saveUser= userService.save(user);
		
		URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(saveUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		User user = userService.deleteById(id);
		if(user == null) {
			throw new UserNotFoundException("id "+id);
		}
	}
	
	@GetMapping("/hello-world-internationalized")
	public String helloWorldInternationalized(){
		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	}
}
