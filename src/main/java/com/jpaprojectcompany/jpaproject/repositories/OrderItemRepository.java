package com.jpaprojectcompany.jpaproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaprojectcompany.jpaproject.entities.OrderItem;
import com.jpaprojectcompany.jpaproject.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{
	
}
