package com.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientVitalDetailsDTO {

	private String height;
	private String weight;
	private String bodyTemperature;
	private String respiratoryRate;
	
}
