package com.iftm.postsMongoDB.config;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.iftm.postsMongoDB.models.entities.User;
import com.iftm.postsMongoDB.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig {
	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void init() {
		userRepository.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, " Alex Brown", "alex@gmail.com");
		User bob = new User(null, " Bob Brown", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
	}
}
