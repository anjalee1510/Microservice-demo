package com.cg.repository;



import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.User;

public interface UserRepository extends MongoRepository<User, String>{

//	public User findByUserName(String userName);
	Optional<User> findByUserName(String userName);

}
