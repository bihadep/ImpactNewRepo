package com.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDataUpdateDTO {

	private String emailId;
	private String contactNumber;
	private String race;
	private String ethnicity;
	private String languagesKnown;
	private String homeAddress;
	
	
}
