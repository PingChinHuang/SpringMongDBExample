package com.superod.core.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.superod.core.model.User;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {

	@Query("{'username': ?0}")
	public List<User> findAllByUsername(String username, String password);
	
	@Query("{'username': ?0}")
	public User findOneByUsername(String username);
	
	@Query("{'_id': ?0}")
	public User findOneById(String id);
	
}
