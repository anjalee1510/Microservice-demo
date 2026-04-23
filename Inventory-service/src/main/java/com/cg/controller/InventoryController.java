package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Inventory;
import com.cg.repository.InventoryRepository;
import com.cg.service.InventoryService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
	
	@Autowired
	InventoryService inventoryService;
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	@PostMapping
	public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) {
		inventoryService.addInventory(inventory);
		return new ResponseEntity<Inventory>(HttpStatus.CREATED);
	}
	
	@GetMapping("/view")
	public ResponseEntity<Object> getInventories() {
		return new ResponseEntity<>(inventoryService.getInventories(),HttpStatus.OK);
	}
	
	@GetMapping("/view/{productCode}")
	public ResponseEntity<Inventory> findByCode(@PathVariable("productCode") String productCode) {
		return new ResponseEntity<>(inventoryService.findByCode(productCode),HttpStatus.OK);
	}
	
	@PutMapping("/update/{pCode}")
	public ResponseEntity<Inventory> updateInventory(@PathVariable("pCode") String productCode,@RequestBody Inventory inventory) {
		inventoryService.updateInventory(productCode,inventory);
		return new ResponseEntity<Inventory>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{productCode}")
	public ResponseEntity<Object> deleteInventory(@PathVariable("productCode") String productCode){
		inventoryService.deleteInventory(productCode);
		return new ResponseEntity<>("Product is deleted successfully",HttpStatus.OK);
	}
	
}
