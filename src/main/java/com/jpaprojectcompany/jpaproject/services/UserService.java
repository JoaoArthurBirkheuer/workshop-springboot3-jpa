package com.jpaprojectcompany.jpaproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpaprojectcompany.jpaproject.entities.User;
import com.jpaprojectcompany.jpaproject.repositories.UserRepository;

// COMPONENT REGISTRATION
// @Service, @Repository

@Service
public class UserService {
	
	@Autowired
	private UserRepository ur;
	
	public List<User>findAll(){
		return ur.findAll();
	}
	
	public User findById(Long id) {
		// Optional = PODE RETORNAR ALGO OU NÃO
		Optional<User> object = ur.findById(id);
		return object.get();
	}
	
	public User insert(User obj) {
		return ur.save(obj);
	}
}
