package com.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyContactDTO {

	private String firstName;
	private String lastName;
	private String relationship;
	private String emailAddress;
	private String contactNumber;
	private String address;
	
}
