package com.mypack.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.mypack.dto.ChangeAppointmentStatusDto;
import com.mypack.dto.SchedularDto;
import com.mypack.entity.Appointment;
import com.mypack.service.PhysicianScheduleService;

@ExtendWith(MockitoExtension.class)
class PhysicianScheduleControllerTest {
	
	@Mock
	PhysicianScheduleService scheduleService;
	
	@InjectMocks
	PhysicianScheduleController controller;

	@Test
	void testAddSchedule() {
		SchedularDto dto = new SchedularDto();
		dto.setEmployeeId("DR");
		when(scheduleService.saveSchedule(dto)).thenReturn(dto);
		assertTrue(controller.addSchedule(dto) instanceof SchedularDto );
	}

	@Test
	void testGetAllEventsByEmployeeId() {
		when(scheduleService.getAllEventsByEmployeeId("DR00")).thenReturn(new ArrayList<>());
		assertEquals(controller.getAllEventsByEmployeeId("DR00").size(), 0);
	}

	@Test
	void testDeletebyId() {
		doNothing().when(scheduleService).deleteById(0L);
		assertEquals(controller.deletebyId(0L).getHttpStatus(), HttpStatus.OK);
	}

	@Test
	void testSendBookingRequest() {
		Appointment appointment = new Appointment();
		appointment.setPatientId("PT000");
		doNothing().when(scheduleService).sendAppointmentRequest(appointment);
		assertEquals(controller.sendBookingRequest(appointment).getHttpStatus(), HttpStatus.OK);
	}

	@Test
	void testGetAllAppointmentByStatusAndUserId() {
		when(scheduleService.getAllAppointmentsBasedOnStatusAndUserid("PENDING", "PT000")).thenReturn(new ArrayList<>());
		assertEquals(controller.getAllAppointmentByStatusAndUserId("PENDING", "PT000").size(), 0);
	}

	@Test
	void testChangeStatus() {
		ChangeAppointmentStatusDto dto = new ChangeAppointmentStatusDto();
		doNothing().when(scheduleService).changeStatus(dto);
		assertEquals(controller.changeStatus(dto).getHttpStatus(), HttpStatus.OK);
	}

}
