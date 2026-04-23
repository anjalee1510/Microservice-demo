package com.cg.service;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.ResourceAlreadyFoundException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.Product;

import com.cg.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	
	public void createProduct(Product product) {
		Optional<Product> localProduct=Optional.ofNullable(productRepository.findByName(product.getName()));
		if(localProduct.isEmpty()) {
			productRepository.save(product);
		}
		else {
			throw new ResourceAlreadyFoundException(product.getName()+" already exists!");
		}
		
	}
	
	
	
	public List<Product> getAllProducts(){
		
		
		 List<Product> lst=productRepository.findAll();
		if(lst.isEmpty()) {
			throw new ResourceNotFoundException("Product list is empty");
		}
		else
		return lst;
		
	}
	
	public Product findByName(String name) {
//		ArrayList<Product> li=(ArrayList<Product>) productRepository.findAll();
//		ArrayList<Product> resultArrayList=new ArrayList<>();
//		for(Product p:li) {
//			if(p.getName().toLowerCase().equals(name.toLowerCase())) {
//				resultArrayList.add(p);
//			}
//		}
//		return resultArrayList;
		 	Optional<Product> productOpt = Optional.ofNullable(productRepository.findByName(name));
		if(productOpt.isPresent())
			return productOpt.get();
		else
		throw new ResourceNotFoundException("Product with name "+name+" doesn't exist");
		}
	
	public void updateProduct(String name,Product product) {
		
		 Optional<Product> localProduct = Optional.ofNullable(productRepository.findByName(name));
		if(localProduct.isPresent()) {
			Product prod= localProduct.get();
//			String id=prod.getId();
			prod.setName(product.getName());
			prod.setDescription(product.getDescription());
			prod.setProductCode(product.getProductCode());
			prod.setPrice(product.getPrice());
			productRepository.save(prod);
		}
		else
		throw new ResourceNotFoundException("Product with name "+name+" doesn't exist");	
		}
	

	
	
	public void deleteProduct(String name) {
		
		 Optional<Product> localProduct = Optional.ofNullable((productRepository.findByName(name)));
		if(localProduct.isPresent()) {
		Product prod= localProduct.get();
		String id=prod.getId();
			productRepository.deleteById(id);
		}
		else
		throw new ResourceNotFoundException("Product with name "+name+" doesn't exist");
		
		
//		productRepository.deleteById(id);
		
	}

}
