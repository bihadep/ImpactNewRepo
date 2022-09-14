package com.patient.dto;

import java.util.List;

import com.patient.entity.AllergicTo;
import com.patient.entity.EmergencyContactInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientExtraDataDTO {

	
	private String race;
	private String ethnicity;
	private String languagesKnown;
	private String homeAddress;
	private List<EmergencyContactInfo> emergencyContactInfo;
	
	private Boolean isAllergic;
	private List<AllergicTo> allergicTo;
}
