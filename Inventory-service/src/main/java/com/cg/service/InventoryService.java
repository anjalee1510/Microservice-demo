package com.cg.service;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.exception.ResourceAlreadyFoundException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.Inventory;
import com.cg.repository.InventoryRepository;

@Service
public class InventoryService {
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	public void addInventory(@RequestBody Inventory inventory) {
		Optional<Inventory> inv=inventoryRepository.findById(inventory.getProductCode());
		if(inv.isEmpty()) {
//			Inventory inv2=inv.get();
			System.out.println( inventory.getProductCode());
			System.out.println( inventory.getQuantity());
		 inventoryRepository.save(inventory);
	}
		else {
			throw new ResourceAlreadyFoundException(inventory.getProductCode()+" already exists!");
		}
	}
	
	public List<Inventory> getInventories(){
		
		List<Inventory> lst=inventoryRepository.findAll();
		if(lst.isEmpty()) {
			throw new ResourceNotFoundException("Product list is empty");
		}
		return lst;
	}
//	public List<Inventory> findByProductCode(String productCode) {
//		Optional<Inventory> prodOpt = inventoryRepository.findById(productCode);
//		if(prodOpt.isPresent())
//			return prodOpt.get();
//		return null;
//		}
	public Inventory findByCode(String productCode) {
		Optional<Inventory> invOpt = inventoryRepository.findById(productCode);
		if(invOpt.isPresent())
			return invOpt.get();
		else {
			throw new ResourceNotFoundException("Product code "+productCode +" already exists");
		}
//		ArrayList<Inventory> li=(ArrayList<Inventory>) inventoryRepository.findAll();
//		ArrayList<Inventory> resultArrayList=new ArrayList<>();
//		for(Inventory m:li) {
//			if(m.getProductCode().toLowerCase().equals(productCode.toLowerCase())) {
//				resultArrayList.add(m);
//			}
//		}
//		return resultArrayList;
		}
	
	public void updateInventory(String productCode, Inventory inventory) {
		Optional<Inventory> invOptional=inventoryRepository.findById(productCode);
			if(invOptional.isPresent()) {
				inventoryRepository.save(inventory);
			}
			else throw new ResourceNotFoundException("Product code "+productCode+" doesn't exist");
		}
		
	public void deleteInventory(String productCode) {
		Optional<Inventory> invOptional=inventoryRepository.findById(productCode);
		if(invOptional.isPresent()) {
		inventoryRepository.deleteById(productCode);
		}
		else throw new ResourceNotFoundException("Product code "+productCode+" doesn't exist");
	}
	
}
