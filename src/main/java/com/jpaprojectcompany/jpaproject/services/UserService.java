package com.jpaprojectcompany.jpaproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jpaprojectcompany.jpaproject.entities.User;
import com.jpaprojectcompany.jpaproject.repositories.UserRepository;
import com.jpaprojectcompany.jpaproject.services.exceptions.DatabaseException;
import com.jpaprojectcompany.jpaproject.services.exceptions.ResourceNotFoundException;

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
		return object.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return ur.save(obj);
	}
	
	public void delete(Long id) {
		try {
		ur.deleteById(id);
		}
		// RETURNS NOT FOUND IF IT'S NOT ON THE DATABASE
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		// RETURNS IF IT VIOLATES THE INTEGRITY OF THE DATABASE
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User u) {
		// PREPARA UM OBJETO MONITORADO PARA MANIPULAR
		// E DEPOIS EXECUTAR OPERAÇÃO NO BANCO DE DADOS
		User entity = ur.getReferenceById(id);
		updateData(entity,u);
		return ur.save(entity);
	}
	
	private void updateData(User entity, User u) {
		entity.setName(u.getName());
		entity.setPhone(u.getPhone());
		entity.setEmail(u.getEmail());
	}
}
