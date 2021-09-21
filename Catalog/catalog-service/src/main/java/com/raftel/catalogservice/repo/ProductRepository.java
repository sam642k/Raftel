package com.raftel.catalogservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.raftel.catalogservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, Integer>{

}
