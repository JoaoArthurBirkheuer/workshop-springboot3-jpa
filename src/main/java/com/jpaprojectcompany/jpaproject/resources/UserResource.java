package com.jpaprojectcompany.jpaproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpaprojectcompany.jpaproject.entities.User;
import com.jpaprojectcompany.jpaproject.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService us;
	
	/// COMPONENT REGISTRATION:
	/// REGISTRO DE SERVIÇOS NO MECANISMO DE GESTÃO DE DEPENDÊNCIAS
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = us.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id)
	{
		User obj = us.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
