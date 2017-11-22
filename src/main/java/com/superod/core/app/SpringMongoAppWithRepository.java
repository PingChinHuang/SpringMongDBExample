package com.superod.core.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.superod.core.model.User;
import com.superod.core.repository.IUserRepository;

@Service
public class SpringMongoAppWithRepository {
	
	@Autowired
	IUserRepository userRepository;
	
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("SpringMongo.xml");
		SpringMongoAppWithRepository springMongoAppWithRepository = (SpringMongoAppWithRepository) ctx.getBean("springMongoAppWithRepository");
		
		User user = new User("audy_repo", "password");
		springMongoAppWithRepository.userRepository.insert(user);
		
		List<User> users = springMongoAppWithRepository.userRepository.findAll();
		for (User u : users) {
			System.out.println(u);
		}
		users = springMongoAppWithRepository.userRepository.findAllbyUsername("superod", "testUpdate");
		for (User u : users) {
			System.out.println("findAllbyUsername " + u);
		}		
		user = springMongoAppWithRepository.userRepository.findAllbyUsername2("audy_repo");
		System.out.println("findAllbyUsername2 " + user);		
	}

}
