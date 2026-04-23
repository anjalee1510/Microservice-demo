package com.capgemini.security.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	

	@ExceptionHandler(ResourceAlreadyFoundException.class)
	public ResponseEntity<?> handleResourceAlreadyFoundException(ResourceAlreadyFoundException exception,WebRequest request){
		ErrorDetails err=new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false));
		return new ResponseEntity<String>("Id already exists", HttpStatus.CONFLICT);
	}
	
}
	
