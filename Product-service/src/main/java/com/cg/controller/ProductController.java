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


import com.cg.model.Product;
import com.cg.repository.ProductRepository;
import com.cg.service.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductRepository productRepository;
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		productService.createProduct(product);
			return new ResponseEntity<Product>(HttpStatus.CREATED);
		}
	
	@GetMapping("/view")
	public ResponseEntity<Object> getAllProducts(){
		return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
	}
	
	@GetMapping("/view/{name}")
	public ResponseEntity<Product> findByName(@PathVariable("name") String name) {
		return new ResponseEntity<>(productService.findByName(name),HttpStatus.OK);
	}
	//create a method to get by name this will be called by order service and
	//productcode can be extracted there
	
	@PutMapping("/update/{name}")
	public ResponseEntity<Product> updateProduct(@PathVariable("name") String name ,@RequestBody Product product) {
		productService.updateProduct(name,product);
		return new ResponseEntity<Product>(HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{name}")
	public ResponseEntity<Object> deleteProduct(@PathVariable("name") String name){
		productService.deleteProduct(name);
		return new ResponseEntity<>("Product is deleted successfully",HttpStatus.OK);
	}
	}


