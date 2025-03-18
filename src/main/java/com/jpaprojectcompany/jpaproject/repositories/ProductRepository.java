package com.jpaprojectcompany.jpaproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaprojectcompany.jpaproject.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
	
}
