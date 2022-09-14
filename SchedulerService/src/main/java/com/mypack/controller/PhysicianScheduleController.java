package com.mypack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypack.dto.ChangeAppointmentStatusDto;
import com.mypack.dto.SchedularDto;
import com.mypack.dto.SuccessResponse;
import com.mypack.dto.TimeslotDto;
import com.mypack.entity.Appointment;
import com.mypack.service.PhysicianScheduleService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/schedule")
@CrossOrigin
@Slf4j
public class PhysicianScheduleController {

	@Autowired
	PhysicianScheduleService scheduleService;

	@PostMapping
	public SchedularDto addSchedule(@RequestBody SchedularDto request) {
		log.info("PhysicianScheduleController >> addSchedule method");
		SchedularDto scheduleDto = scheduleService.saveSchedule(request);
		return scheduleDto;
	}

	@GetMapping("/getAllEventsByEmployeeId/{employeeId}")
	public List<SchedularDto> getAllEventsByEmployeeId(@PathVariable("employeeId") String employeeId) {
		log.info("PhysicianScheduleController >> getAllEventsByEmployeeId method");
		return scheduleService.getAllEventsByEmployeeId(employeeId);
	}

	@DeleteMapping("/deleteById/{id}")
	public SuccessResponse deletebyId(@PathVariable("id") Long id) {
		log.debug("PhysicianScheduleController >> deletebyId");
		scheduleService.deleteById(id);
		return new SuccessResponse("event deleted successfully", HttpStatus.OK);
	}

	
	@PostMapping("/sendBookingRequest")
	public SuccessResponse sendBookingRequest(@RequestBody Appointment appointment) {
		log.debug("PhysicianScheduleController >> sendBookingRequest");
		scheduleService.sendAppointmentRequest(appointment);
		return new SuccessResponse("Request send successfully", HttpStatus.OK);
	}
	
	@GetMapping("/getAppointment/{status}/{userId}")
	public List<Appointment> getAllAppointmentByStatusAndUserId(@PathVariable("status") String status, 
													@PathVariable("userId") String userId){
		log.debug("PhysicianScheduleController >> getAllAppointmentByStatusAndUserId");
		return scheduleService.getAllAppointmentsBasedOnStatusAndUserid(status, userId);
	}
	
	@PutMapping("/changeStatus")
	public SuccessResponse changeStatus(@RequestBody ChangeAppointmentStatusDto request){
		log.debug("PhysicianScheduleController >> changeStatus");
		scheduleService.changeStatus(request);
		return new SuccessResponse("Appointment status changed to " + request.getStatus(), HttpStatus.OK);
	}
	
}
