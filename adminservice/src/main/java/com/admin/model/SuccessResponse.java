package com.admin.model;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuccessResponse {
	
	private HttpStatus httpStatus;
	
	private String message;
	
	
}