package com.cg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/page")
public class HomeController {
	
	@GetMapping("/hello")
	public String home() {
		return ("Welcome to Home Page!");
	}
	
	@GetMapping("/welcome")
	public String user() {
		return ("Welcome User");
	}
	
//	@GetMapping("/admin")
//	public String admin() {
//		return("Welcome Admin");
//	}
//	
//	@GetMapping("api/product")
//	public String some() {
//		return "hello";
//	}

}
