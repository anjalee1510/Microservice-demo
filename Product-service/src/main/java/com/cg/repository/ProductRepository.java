package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.Product;

public interface ProductRepository extends MongoRepository<Product,String>{
	public Product findByName(String name);
}
