package com.jpaprojectcompany.jpaproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpaprojectcompany.jpaproject.entities.Product;
import com.jpaprojectcompany.jpaproject.repositories.ProductRepository;

// COMPONENT REGISTRATION
// @Service, @Repository

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository pr;
	
	public List<Product>findAll(){
		return pr.findAll();
	}
	
	public Product findById(Long id) {
		// Optional = PODE RETORNAR ALGO OU NÃO
		Optional<Product> object = pr.findById(id);
		return object.get();
	}
}
