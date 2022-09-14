package com.pms.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
	
	private String token;
	private String message;
	private HttpStatus status;
	private boolean isPasswordChanged;
}
