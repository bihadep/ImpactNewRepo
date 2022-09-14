package com.mypack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypack.dto.PatientNotificationResponse;
import com.mypack.dto.SuccessResponse;
import com.mypack.service.PatientNotificationService;

@RestController
@RequestMapping("/patient")
@CrossOrigin
public class PatientNotificationController {
	
	@Autowired
	PatientNotificationService patientService;

	@GetMapping("/getNotification/{patientId}")
	public List<PatientNotificationResponse> getNotification(@PathVariable("patientId") Long patientId){
		return patientService.getNotificationByPatientId(patientId);
	}
	
	@PutMapping("/notificationRead/{notificationId}")
	public SuccessResponse notificationRead(@PathVariable("notificationId") Long notificationId) {
		patientService.readNotification(notificationId);
		SuccessResponse response = new SuccessResponse(HttpStatus.OK, "Read Notification");
		return response;
	}
}
