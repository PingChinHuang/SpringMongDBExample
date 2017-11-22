package com.superod.core.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.superod.core.bo.BoUser;
import com.superod.core.model.User;

public class SpringMongoAppWithRepository {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("SpringMongo.xml");
		BoUser boUser = (BoUser) ctx.getBean("boUser");
		
		boUser.createUser("audy_test", "password");
		boUser.createUser("audy_test", "password");
		
		String deleteCandidateId = "";
		List<User> users = boUser.queryUsers();
		for (User u: users) {
			System.out.println(u);
			deleteCandidateId = u.getId();
		}
		
		/*boUser.updateUser("audy_test", "new password");
		

		List<User> users = boUser.queryUsers();
		for (User u: users) {
			System.out.println(u);
			deleteCandidateId = u.getId();
		}
		
		boUser.deleteUserById(deleteCandidateId);
		boUser.deleteUserByUsername("audy_test");
		
		System.out.println("After delete");
		users = boUser.queryUsers();
		for (User u: users) {
			System.out.println(u);
		}*/
	}

}
