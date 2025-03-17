package com.jpaprojectcompany.jpaproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaprojectcompany.jpaproject.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{
	
}
