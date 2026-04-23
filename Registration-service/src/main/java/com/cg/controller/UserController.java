package com.cg.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.User;
import com.cg.repository.UserRepository;
import com.cg.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	
	@PostMapping("/register")
	public ResponseEntity<Object> createUser(@RequestBody User user){
		userService.createUser(user);
		return new ResponseEntity<>("User is added successfully",HttpStatus.CREATED);
	}
	
	@GetMapping("profile/{userName}")
	public ResponseEntity<Object> findByUserName(@PathVariable("userName") String userName) {
		return new ResponseEntity<>(userService.findByUserName(userName),HttpStatus.FOUND);
	}
	
	@GetMapping("/userlist")
	public ResponseEntity<Object> getUsers(){
		return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
		
	}
	
	@PutMapping("update/{userName}")
	public ResponseEntity<Object> updateUser(@PathVariable("userName") String UserName,@RequestBody User user) {
		
		userService.updateUser(UserName, user);
		return new ResponseEntity<>("User is updated successfully",HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{userName}")
	public ResponseEntity<Object> deleteUser(@PathVariable("userName") String userName) {
		userService.deleteUser(userName);
		return new ResponseEntity<>("User is deleted successfully",HttpStatus.OK);
	}
		
}
