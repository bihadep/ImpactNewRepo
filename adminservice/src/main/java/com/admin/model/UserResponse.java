package com.admin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
	
	
	private String employeeId;
	private String firstName;
	private String lastName;
	private Boolean status;
	private String dateOfJoining;
	
	
}