package com.raftel.catalogservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.raftel.catalogservice.model.IdGenerator;

public interface IdRepository extends MongoRepository<IdGenerator, String>{

}
