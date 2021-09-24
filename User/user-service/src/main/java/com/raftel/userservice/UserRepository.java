package com.raftel.userservice;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.raftel.userservice.model.User;

public interface UserRepository extends MongoRepository<User, String>{
	
	User findByEmail(String email);

}
