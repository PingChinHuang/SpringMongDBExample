package com.superod.core.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superod.core.model.User;
import com.superod.core.repository.IUserRepository;

@Service
public class BoUser {

	@Autowired
	IUserRepository userRepository;
	
	public void createUser(String username, String password)
	{
		userRepository.insert(new User(username, password));
	}
	
	public void updateUser(String username, String password)
	{
		User user = userRepository.findOneByUsername(username);
		user.setUsername(username);
		user.setPassword(password);
		userRepository.save(user);
	}
	
	public void deleteUserByUsername(String username)
	{
		User user = userRepository.findOneByUsername(username);
		System.out.println("delete user with name: " + username);
		userRepository.delete(user);
	}
	
	public void deleteUserById(String id)
	{
		User user = userRepository.findOneById(id);
		System.out.println("delete user with ID: " + id);
		userRepository.delete(user);
	}
	
	public User queryUserByUsername(String username)
	{
		return userRepository.findOneByUsername(username);
	}
	
	public List<User> queryUsers()
	{
		return userRepository.findAll();
	}
	
	public User queryUserById(String id)
	{
		return userRepository.findOneById(id);
	}
}
