package com.mypack.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeslotDto {

	private Long id;
	private String date;
	private String startTime;
	private String endTime;
	
}
