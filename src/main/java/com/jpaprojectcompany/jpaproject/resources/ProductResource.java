package com.jpaprojectcompany.jpaproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpaprojectcompany.jpaproject.entities.Product;
import com.jpaprojectcompany.jpaproject.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService ps;
	
	/// COMPONENT REGISTRATION:
	/// REGISTRO DE SERVIÇOS NO MECANISMO DE GESTÃO DE DEPENDÊNCIAS
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = ps.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id)
	{
		Product obj = ps.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
