package com.superod.core.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.superod.core.model.User;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {

	@Query("{'username': ?0, 'password': ?1}")
	public List<User> findAllbyUsername(String username, String password);
	
	@Query("{'username': ?0}")
	public User findAllbyUsername2(String username);
}
