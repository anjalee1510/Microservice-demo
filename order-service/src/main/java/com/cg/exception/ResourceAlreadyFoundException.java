package com.cg.exception;
public class ResourceAlreadyFoundException extends RuntimeException{
	private static final long serialVersionUID =1L;
	public ResourceAlreadyFoundException(String message) {
		super(message);
	}
}
