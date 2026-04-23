package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//import org.springframework.context.annotation.Bean;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;


//import com.cg.model.RegUser;

@SpringBootApplication
@EnableEurekaClient
public class LoginServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginServiceApplication.class, args);
	}
//	@Bean
//	public RestTemplate getRestTemplate() {
//		return new RestTemplate();
//	}
//	
//	private RestTemplate restTemplate;
//	
//	ResponseEntity<RegUser[]> regUser= restTemplate.getForEntity("http://localhost:8085/userlist",RegUser[].class);
//	RegUser[] users= regUser.getBody(); 
//
//
//	for(int i=0;i<users.length();i++) {
		
	

	
	
	}


