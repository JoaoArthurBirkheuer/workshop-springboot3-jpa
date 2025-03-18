package com.jpaprojectcompany.jpaproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpaprojectcompany.jpaproject.entities.Category;
import com.jpaprojectcompany.jpaproject.repositories.CategoryRepository;

// COMPONENT REGISTRATION
// @Service, @Repository

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository cr;
	
	public List<Category>findAll(){
		return cr.findAll();
	}
	
	public Category findById(Long id) {
		// Optional = PODE RETORNAR ALGO OU NÃO
		Optional<Category> object = cr.findById(id);
		return object.get();
	}
}
