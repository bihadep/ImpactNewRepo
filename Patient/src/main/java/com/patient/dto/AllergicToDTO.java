package com.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllergicToDTO {

	private Long allergyId;
	private String allergyType;
	private String allergyName;
	private String allergyDecription;
	private String allergyClinicalInfo;

}
