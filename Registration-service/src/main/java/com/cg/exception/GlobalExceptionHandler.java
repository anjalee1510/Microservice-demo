package com.cg.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception,WebRequest request){
		ErrorDetails err=new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false));
		return new  ResponseEntity(err,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ResourceAlreadyFoundException.class)
	public ResponseEntity<?> handleResourceAlreadyFoundException(ResourceAlreadyFoundException exception,WebRequest request){
		ErrorDetails err=new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false));
		return new  ResponseEntity(err,HttpStatus.ALREADY_REPORTED);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception exception,WebRequest request){
		ErrorDetails err=new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false));
		return new  ResponseEntity(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
	
