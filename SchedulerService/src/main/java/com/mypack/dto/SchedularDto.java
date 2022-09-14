package com.mypack.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchedularDto {

	private Long id;
	private String subject;
	private String startTime;
	private String endTime;
	private String description;
	private boolean IsAllDay = false;
	private String employeeId;
	private Long empDbId;
}
