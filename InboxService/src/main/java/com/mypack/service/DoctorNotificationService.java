package com.mypack.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.mypack.dto.DoctorNotificationResponse;
import com.mypack.dto.NotificationRequest;
import com.mypack.dto.RejectMeetingDto;
import com.mypack.entity.DoctorNotification;
import com.mypack.repo.DoctorNotificationRepo;

@Service
public class DoctorNotificationService {

	@Autowired
	DoctorNotificationRepo doctorNotificationRepo;

	@Autowired
	PatientNotificationService patientNotificationService;

	public List<DoctorNotificationResponse> getNotificationByDoctorId(Long userId) {
		List<DoctorNotification> notificationList = doctorNotificationRepo
				.findByDoctorIdAndIsAcceptAndReasonForRejectIsNull(userId, false);
		if (!CollectionUtils.isEmpty(notificationList)) {
			return notificationList.stream().map(notification -> {
				DoctorNotificationResponse response = new DoctorNotificationResponse();
				response.setNotificationId(notification.getId());
				response.setNotification(notification.getNotification());
				response.setReasonForReject(notification.getReasonForReject());
				response.setAccept(notification.isAccept());
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

	public Long getDoctorNotificationCountById(Long doctorId) {
		return doctorNotificationRepo.getNotificationCount(doctorId);
	}

	public void sendNotificationToDoctor(NotificationRequest request) {

		DoctorNotification notification = new DoctorNotification();
		notification.setNotification("PATIENT_NAME with ID " + request.getPatientId() + " has scheduled appointment on "
				+ request.getScheduleDate() + " at " + request.getScheduleTime());
		notification.setAccept(false);
		notification.setScheduleDate(request.getScheduleDate());
		notification.setScheduleTime(request.getScheduleTime());
		notification.setDoctorId(request.getDoctorId());
		notification.setPatientId(request.getPatientId());
		doctorNotificationRepo.save(notification);

	}

	public boolean acceptScheduleMeeting(Long notificationId) {
		Optional<DoctorNotification> notification = doctorNotificationRepo.findById(notificationId);
		if (notification.isPresent()) {
			DoctorNotification notifictnDb = notification.get();
			notifictnDb.setAccept(true);
			notifictnDb.setUpdateDate(new Date());
			doctorNotificationRepo.save(notifictnDb);

			// SENDING NOTIFICATION TO PATIENT SAYING THAT APPOINTMENT IS APPROVED BY
			// DOCTOR.
			NotificationRequest request = new NotificationRequest(notifictnDb.getDoctorId(),
					notifictnDb.getScheduleDate(), notifictnDb.getScheduleTime(), notifictnDb.getPatientId());
			patientNotificationService.sendNotificationToPatient(request, "accept");

			// LOGIC TO SAVE DATA TO APPOINMENT TABLE IN SECHEDULING SERVICE

			return true;

		}
		return false;
	}

	public boolean rejectScheduleMeeting(RejectMeetingDto dto) {
		Optional<DoctorNotification> notification = doctorNotificationRepo.findById(dto.getNotificationId());
		if (notification.isPresent()) {
			DoctorNotification notifictnDb = notification.get();
			notifictnDb.setAccept(false);
			notifictnDb.setReasonForReject(dto.getReasonForReject());
			notifictnDb.setUpdateDate(new Date());
			doctorNotificationRepo.save(notifictnDb);

			// SENDING NOTIFICATION TO PATIENT SAYING THAT APPOINTMENT IS REJECTED BY
			// DOCTOR.
			NotificationRequest request = new NotificationRequest(notifictnDb.getDoctorId(),
					notifictnDb.getScheduleDate(), notifictnDb.getScheduleTime(), notifictnDb.getPatientId());
			patientNotificationService.sendNotificationToPatient(request, "reject");
			
			// DELETE RECORD FROM NOTIFICATION TABLE AND SAVE RECORD TO APPOINTMENT_HISTORY TABLE .

			return true;
		}
		return false;
	}
}
