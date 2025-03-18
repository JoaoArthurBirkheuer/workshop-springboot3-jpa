package com.jpaprojectcompany.jpaproject.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	// NO POSTMAN
	// MUDAR PARA 'POST' > Body > Raw > COPIAR OBJETO
	// COLOCAR NA OPÇÃO (JSON(application/JSON)) AO INVES DE TEXT
	
	// post on /users
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User u){
		u = us.insert(u);
		// return ResponseEntity.ok().body(u);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path
				("/{id}").buildAndExpand(u.getId()).toUri();
		// RETURNS 201 RESPONSE INSTEAD OF 200
		return ResponseEntity.created(uri).body(u);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		us.delete(id);
		return ResponseEntity.noContent().build();
		// IF CLIENT HAS ORDERS, RETURNS 500 DUE TO VIOLATION OF INTEGRITY OF THE DATABASE
		// POSTMAN IS NOT PROVIDING THE MESSAGE OF ERROR
	}
	
	// UPDATE = PUT
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id,
			@RequestBody User obj){
		obj = us.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
