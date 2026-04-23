package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.ResourceAlreadyFoundException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.User;

import com.cg.repository.UserRepository;

@Service
public class UserService{
	
	@Autowired
	UserRepository userRepository;
	
	
	public void createUser(User user) {
		Optional<User> localUser= userRepository.findById(user.getUserName());
		if(localUser.isEmpty()) {
			userRepository.save(user);
		}
		else
		throw new ResourceAlreadyFoundException("Username already exists!");
	}


	public Object findByUserName(String userName) {
		Optional<User> userOpt = userRepository.findById(userName);
		if(userOpt.isPresent())
			return userOpt.get();
		else
		throw new ResourceNotFoundException("User doesn't exist");
		}


	public List<User> getUsers() {
		
		List<User> lst=userRepository.findAll();
		if(lst.isEmpty()) {
			throw new ResourceNotFoundException("No user registered");
		}
		else
		return lst;
	}


	public void updateUser(String userName, User user) {
		Optional<User> localUser = userRepository.findById(userName);
		if(localUser.isPresent()) {
			userRepository.save(user);
		}
		else
		throw new ResourceNotFoundException("User with username - "+ userName+" doesn't exist");
		
	}


	public void deleteUser(String userName) {
		Optional<User> localUser = userRepository.findById(userName);
		if(localUser.isPresent()) {
			userRepository.deleteById(userName);
		}
		else
		throw new ResourceNotFoundException("User with username - "+ userName+" doesn't exist");
		
	}
	
}
