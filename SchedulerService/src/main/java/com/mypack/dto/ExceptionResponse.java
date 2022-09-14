package com.mypack.dto;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
	
	
	 private Date timestamp;
	    private String message;
	    private HttpStatus httpStatus;
	    
	    
}