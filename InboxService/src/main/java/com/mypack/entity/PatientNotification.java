package com.mypack.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patient_notification_tb")
public class PatientNotification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String notification;
	private boolean isRead;
	private String scheduleDate;
	private String scheduleTime;
	private Long doctorId;
	private Long patientId;
	@Column(updatable = false)
	private Date createdDate = new Date();
	private Date updateDate;
}
