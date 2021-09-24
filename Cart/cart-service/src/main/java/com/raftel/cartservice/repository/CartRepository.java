package com.raftel.cartservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.raftel.cartservice.model.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart, Integer>{

}
