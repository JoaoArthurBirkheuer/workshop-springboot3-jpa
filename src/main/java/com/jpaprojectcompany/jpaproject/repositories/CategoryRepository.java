package com.jpaprojectcompany.jpaproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaprojectcompany.jpaproject.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{
	
}
