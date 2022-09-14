package com.mypack.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorNotificationResponse {

	private Long notificationId;
	private String notification;
	private String reasonForReject;
	private boolean isAccept;
	private Long doctorId;
	private String doctorName;
	private String scheduleDate;
	private String scheduleTime;
	private Long patientId;
	private String patientName;
	private Date createdDate;

}
