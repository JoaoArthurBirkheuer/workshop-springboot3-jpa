package com.jpaprojectcompany.jpaproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaprojectcompany.jpaproject.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{
	
}
