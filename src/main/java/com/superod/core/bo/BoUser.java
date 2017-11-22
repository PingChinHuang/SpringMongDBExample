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
	
	public User createUser(User user)
	{
		return userRepository.insert(user);
	}
	
	public User createUser(String username, String password)
	{
		return createUser(new User(username, password));
	}
	
	public User updateUser(User user)
	{
		return userRepository.save(user);	
	}
	
	public User updateUser(String username, String password)
	{
		User user = userRepository.findOneByUsername(username);
		//user.setUsername(username);
		user.setPassword(password);
		return updateUser(user);
	}
	
	public void deleteUser(User user)
	{
		userRepository.delete(user);
	}
	
	public void deleteUserByUsername(String username)
	{
		User user = userRepository.findOneByUsername(username);
		System.out.println("delete user with name: " + username);
		deleteUser(user);
	}
	
	public void deleteUserById(String id)
	{
		User user = userRepository.findOneById(id);
		System.out.println("delete user with ID: " + id);
		deleteUser(user);
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
