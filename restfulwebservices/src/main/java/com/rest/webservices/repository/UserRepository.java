package com.rest.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.webservices.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
