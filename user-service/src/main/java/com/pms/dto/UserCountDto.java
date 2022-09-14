package com.pms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCountDto {
	
	private Long physicianCount;
	private Long nurseCount;
	private Long patientCount;

}
