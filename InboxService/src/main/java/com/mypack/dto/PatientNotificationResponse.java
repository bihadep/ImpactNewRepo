package com.mypack.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientNotificationResponse {

	private Long id;
	private String notification;
	private boolean isRead;
	private Long doctorId;
	private String doctorName;
	private String scheduleDate;
	private String scheduleTime;
	private Long patientId;
	private String patientName;
	private Date createdDate;
}
