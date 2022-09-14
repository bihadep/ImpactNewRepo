package com.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientSignupDTO {

	private String title;
	private String firstName;
	private String lastName;
	private String emailId;
	private String dateOfBirth;
	private int age;
	private String contactNumber;	
	private String password;
	
	
}
