package com.pms.dto;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponseDto {
	
	
	 private Date timestamp;
	    private String message;
	    private HttpStatus httpStatus;
	    
	    
}