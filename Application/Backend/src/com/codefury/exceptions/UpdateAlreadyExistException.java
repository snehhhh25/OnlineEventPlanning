package com.codefury.exceptions;

public class UpdateAlreadyExistException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;
	public UpdateAlreadyExistException() {
		super();
		
	}
	public UpdateAlreadyExistException(String message) {
		super();
		this.message=message;
		
	}
	public UpdateAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
		
	}

	@Override
    public String getMessage() {
    	return this.message;
    }
	
	

}
