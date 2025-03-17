package com.jpaprojectcompany.jpaproject.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jpaprojectcompany.jpaproject.entities.Order;
import com.jpaprojectcompany.jpaproject.entities.User;
import com.jpaprojectcompany.jpaproject.repositories.OrderRepository;
import com.jpaprojectcompany.jpaproject.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	/// SPRING RESOLVE ESSA DEPENDÊNCIA E ASSOCIA UMA INSTÂNCIA
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User u1 = new User(null, "M", "m@gmail.com", "9898", "1234");
		User u2 = new User(null, "T", "t@gmail.com", "8989", "4321");
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		// USERS COME BEFORE ORDERS
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
	
}
