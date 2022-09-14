package com.mypack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypack.dto.DoctorNotificationResponse;
import com.mypack.dto.NotificationRequest;
import com.mypack.dto.RejectMeetingDto;
import com.mypack.dto.SuccessResponse;
import com.mypack.service.DoctorNotificationService;

@RestController
@RequestMapping("/doctor")
@CrossOrigin
public class DoctorNotificationController {

	@Autowired
	DoctorNotificationService doctorService;

	@PostMapping("/sendNotification")
	public SuccessResponse sendNotification(@RequestBody NotificationRequest request) {
		doctorService.sendNotificationToDoctor(request);
		SuccessResponse response = new SuccessResponse(HttpStatus.OK, "Notification sent");
		return response;
	}

	@GetMapping("/getNotifications/{doctorId}")
	public List<DoctorNotificationResponse> getNotification(@PathVariable("doctorId") long doctorId) {
		return doctorService.getNotificationByDoctorId(doctorId);
	}
	
	@GetMapping("/getNotificationCount/{doctorId}")
	public Long getNotificationCount(@PathVariable("doctorId") long doctorId) {
		return doctorService.getDoctorNotificationCountById(doctorId);
	}
	
	@PutMapping("/acceptMeeting/{notificationId}")
	public SuccessResponse acceptMeeting(@PathVariable("notificationId") long notificationId) {
		doctorService.acceptScheduleMeeting(notificationId);
		SuccessResponse response = new SuccessResponse(HttpStatus.OK, "Appointment Scheduled");
		return response;
	}
	
	@PutMapping("/rejectMeeting")
	public SuccessResponse rejectMeeting(@RequestBody RejectMeetingDto dto) {
		doctorService.rejectScheduleMeeting(dto);
		SuccessResponse response = new SuccessResponse(HttpStatus.OK, "Appointment Cancelled");
		return response;
	}
}
