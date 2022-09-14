package com.admin.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {


	private Long id;

	private String title;
	private String firstName;
	private String lastName;
	
	private String emailId;
	
	private String dateOfBirth;
	
	private String dateOfJoining;
	
	private Boolean status;
	
	private Login login;
	
	private String employeeId;
	
}
