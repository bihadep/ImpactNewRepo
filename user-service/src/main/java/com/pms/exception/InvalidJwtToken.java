package com.pms.exception;

public class InvalidJwtToken extends RuntimeException{
	public InvalidJwtToken(String message){
		super(message);
	}
}
