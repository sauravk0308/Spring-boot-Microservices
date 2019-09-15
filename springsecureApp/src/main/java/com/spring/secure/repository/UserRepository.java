package com.spring.secure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.secure.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
