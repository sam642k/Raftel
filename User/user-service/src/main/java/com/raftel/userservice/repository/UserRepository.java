package com.raftel.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.raftel.userservice.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer>{

}
