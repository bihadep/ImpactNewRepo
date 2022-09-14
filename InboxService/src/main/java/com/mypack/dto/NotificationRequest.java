package com.mypack.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {

	private Long doctorId;
	private String scheduleDate;
	private String scheduleTime;
	private Long patientId;
	
}
