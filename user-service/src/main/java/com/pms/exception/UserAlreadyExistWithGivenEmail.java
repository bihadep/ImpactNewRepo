package com.pms.exception;

public class UserAlreadyExistWithGivenEmail extends RuntimeException {

	public UserAlreadyExistWithGivenEmail() {
		super();
	}



	public UserAlreadyExistWithGivenEmail(String msg) {
		super(msg);
	}

}	
