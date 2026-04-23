package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.Order;

public interface OrderRepository extends MongoRepository<Order, String> {

}
