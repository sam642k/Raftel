package com.raftel.orderservice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.raftel.orderservice.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Integer> {

}
