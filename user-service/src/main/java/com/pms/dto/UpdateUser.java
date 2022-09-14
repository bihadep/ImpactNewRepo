package com.pms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUser {
	
	
	
	private String employeeId;
	
	private boolean status;
	
	private String password;
	
	
}
