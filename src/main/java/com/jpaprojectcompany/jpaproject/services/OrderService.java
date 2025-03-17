package com.jpaprojectcompany.jpaproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpaprojectcompany.jpaproject.entities.Order;
import com.jpaprojectcompany.jpaproject.repositories.OrderRepository;

// COMPONENT REGISTRATION
// @Service, @Repository

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository or;
	
	public List<Order>findAll(){
		return or.findAll();
	}
	
	public Order findById(Long id) {
		// Optional = PODE RETORNAR ALGO OU NÃO
		Optional<Order> object = or.findById(id);
		return object.get();
	}
}
