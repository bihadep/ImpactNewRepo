package com.patient.dto;

import java.util.List;

public class PatientDetailedDataDTO {

	private Long patientId;
	private String race;
	private String ethnicity;
	private String languagesKnown;
	private String homeAddress;
	
	private List<EmergencyContactDTO> emergencyContactDTO;
}
