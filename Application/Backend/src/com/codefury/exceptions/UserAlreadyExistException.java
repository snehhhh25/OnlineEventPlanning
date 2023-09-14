package com.codefury.exceptions;

public class UserAlreadyExistException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;
	public UserAlreadyExistException() {
		super();
	}
	public UserAlreadyExistException(String message) {
		super();
		this.message=message;

	}
	public UserAlreadyExistException(String message, Throwable cause) {
		super(message, cause);

	}
	
    @Override
    public String getMessage() {
    	return this.message;
    }
     
}
