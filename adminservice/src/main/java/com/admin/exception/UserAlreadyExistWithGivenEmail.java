package com.admin.exception;

public class UserAlreadyExistWithGivenEmail extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public UserAlreadyExistWithGivenEmail() {
		super();
	}



	public UserAlreadyExistWithGivenEmail(String msg) {
		super(msg);
	}

}	
