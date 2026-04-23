package com.cg.repository;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.Inventory;


public interface InventoryRepository extends MongoRepository<Inventory, String>{
	List<Inventory> findByProductCode(String productCode);
}
