package com.jpaprojectcompany.jpaproject.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jpaprojectcompany.jpaproject.entities.User;
import com.jpaprojectcompany.jpaproject.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	/// SPRING RESOLVE ESSA DEPENDÊNCIA E ASSOCIA UMA INSTÂNCIA
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User u1 = new User(null, "M", "m@gmail.com", "9898", "1234");
		User u2 = new User(null, "T", "t@gmail.com", "8989", "4321");
		
		userRepository.saveAll(Arrays.asList(u1,u2));
	}
	
}
