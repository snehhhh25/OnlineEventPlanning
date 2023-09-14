package com.codefury.exceptions;

public class InvalidAccessException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;
    
    public InvalidAccessException() {
		super();
		
	}

    public InvalidAccessException(String message) {
		super();
		this.message=message;	
	}
    
	public InvalidAccessException(String message, Throwable cause) {
		super(message, cause);
		
	}

	

	@Override
    public String getMessage() {
    	return this.message;
    }
     
}
