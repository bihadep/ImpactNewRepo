package com.mypack.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.mypack.dto.NotificationRequest;
import com.mypack.dto.PatientNotificationResponse;
import com.mypack.entity.PatientNotification;
import com.mypack.repo.PatientNotificationRepo;

@Service
public class PatientNotificationService {

	@Autowired
	PatientNotificationRepo patientNotificationRepo;

	public List<PatientNotificationResponse> getNotificationByPatientId(Long userId) {
		List<PatientNotification> notificationList = patientNotificationRepo.findByPatientIdAndIsRead(userId, false);
		if (!CollectionUtils.isEmpty(notificationList)) {
			return notificationList.stream().map(notification -> {
				PatientNotificationResponse response = new PatientNotificationResponse();
				response.setId(notification.getId());
				response.setNotification(notification.getNotification());
				response.setRead(notification.isRead());
				response.setDoctorId(notification.getDoctorId());
				response.setDoctorName("Doctor-Name");
				response.setPatientId(notification.getPatientId());
				response.setPatientName("Patient-Name");
				response.setScheduleDate(notification.getScheduleDate());
				response.setScheduleTime(notification.getScheduleTime());
				response.setCreatedDate(notification.getCreatedDate());
				return response;
			}).collect(Collectors.toList());
		}
		return new ArrayList<>();

	}

	public Long getPatientrNotificationCountById(Long patientId) {
		return patientNotificationRepo.getNotificationCount(patientId);
	}

	public void sendNotificationToPatient(NotificationRequest request, String action) {
		PatientNotification notification = new PatientNotification();
		if ("accept".equalsIgnoreCase(action)) {
			notification
					.setNotification("PATIENT_NAME your appointment  has been approved by doctor. /n Appointment date: "
							+ request.getScheduleDate() + " at " + request.getScheduleTime());
		} else {
			notification
			.setNotification("PATIENT_NAME your appointment  scheduled on. /n Appointment date: "
					+ request.getScheduleDate() + " at " + request.getScheduleTime() + " has been rejected. Please book some other day "
							+ "appointment");
		}
		notification.setRead(false);
		notification.setScheduleDate(request.getScheduleDate());
		notification.setScheduleTime(request.getScheduleTime());
		notification.setDoctorId(request.getDoctorId());
		notification.setPatientId(request.getPatientId());
		patientNotificationRepo.save(notification);

	}
	
	public void readNotification(Long notificationId) {
		PatientNotification notification = patientNotificationRepo.findById(notificationId).get();
		notification.setRead(true);
		notification.setUpdateDate(new Date());
		patientNotificationRepo.save(notification);
	}

}
