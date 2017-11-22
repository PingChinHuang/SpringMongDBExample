package com.superod.core.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.superod.core.model.User;

public class SpringMongoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new GenericXmlApplicationContext("SpringMongo.xml");
		MongoOperations mongoOperations = (MongoOperations) ctx.getBean("mongoTemplate");
		
		User user = new User("audy", "password");
		
		mongoOperations.save(user);
		System.out.println(user);
		
		//user.setPassword("new password");
		//mongoOperations.save(user);
		
		/*List<User> queryResults = mongoOperations.find(Query.query(Criteria.where("username").is("audy")), User.class);
		for (User u : queryResults) {
			u.setPassword("testUpdate");
			mongoOperations.save(u);
		}*/
		
		// Update Multiple Documents
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is("audy"));
		Update update = new Update();
		update.set("username", "superod");
		mongoOperations.updateMulti(query, update, User.class);
		
	}

}
