package com.mypack.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.ObjectUtils;

import com.mypack.dto.ChangeAppointmentStatusDto;
import com.mypack.dto.SchedularDto;
import com.mypack.entity.Appointment;
import com.mypack.entity.PhysicianSchedule;
import com.mypack.repo.AppointmentRepo;
import com.mypack.repo.PhysicianScheduleRepo;

@ExtendWith(MockitoExtension.class)
class PhysicianScheduleServiceTest {

	@Mock
	PhysicianScheduleRepo scheduleRepo;

	@Mock
	AppointmentRepo appointmentRepo;

	@InjectMocks
	PhysicianScheduleService schedulerService;

	public PhysicianSchedule mapDtoToEntity(SchedularDto request) {
		PhysicianSchedule entity = new PhysicianSchedule();
		if (!ObjectUtils.isEmpty(request.getId())) {
			entity.setId(request.getId());
		}
		entity.setDoctorId(request.getEmpDbId());
		entity.setEmployeeId(request.getEmployeeId());
		entity.setStartTime(request.getStartTime());
		entity.setEndTime(request.getEndTime());
		entity.setSubject(request.getSubject());
		entity.setDescription(request.getDescription());
		return entity;
	}

	@Test
	void testSaveSchedule() {
		SchedularDto dto = new SchedularDto();
		dto.setSubject("Available");
		dto.setEmployeeId("DR000");
		dto.setEmpDbId(0L);
		dto.setStartTime("2022-07-20T09:00:00.000Z");
		dto.setEndTime("2022-07-20T09:30:00.000Z");

		SchedularDto dto1 = new SchedularDto();
		dto1.setSubject("Available");
		dto1.setEmployeeId("DR000");
		dto1.setEmpDbId(0L);
		dto1.setStartTime("2022-07-20T14:30:00.000Z");
		dto1.setEndTime("2022-07-20T15:00:00.000Z");
		when(scheduleRepo.save(mapDtoToEntity(dto1))).thenReturn(mapDtoToEntity(dto1));
		assertTrue(schedulerService.saveSchedule(dto) instanceof SchedularDto);
	}

	
	@Test
	void testSaveScheduleForException() {
		SchedularDto dto = new SchedularDto();
		dto.setSubject("Available");
		dto.setEmployeeId("DR000");
		dto.setEmpDbId(0L);
		dto.setStartTime("NO-DATE");
		dto.setEndTime("NO-");

		assertThrows(Exception.class, ()->{
			schedulerService.saveSchedule(dto);
		} );	
	}
	
	public List<PhysicianSchedule> getDummyDataOfEventOfEmployee() {
		List<PhysicianSchedule> list = new ArrayList<>();
		list.add(new PhysicianSchedule(1L, "Subject", "2022-07-20T14:30:00.000Z", "2022-07-20T15:00:00.000Z", 0L,
				"DR00", "Desc"));
		return list;
	}

	@Test
	void testGetAllEventsByEmployeeId() {
		when(scheduleRepo.findByEmployeeId("DR00")).thenReturn(getDummyDataOfEventOfEmployee());
		assertEquals(schedulerService.getAllEventsByEmployeeId("DR00").size(), 1);
	}

	@Test
	void testGetAllEventsByEmployeeIdWithNoEvent() {
		when(scheduleRepo.findByEmployeeId("DR00")).thenReturn(null);
		assertEquals(schedulerService.getAllEventsByEmployeeId("DR00").size(), 0);
	}

	@Test
	void testGetAllAppointmentsBasedOnStatusAndUseridForPatientForAllStatus() {
		when(appointmentRepo.findByPatientId("PT000")).thenReturn(new ArrayList<>());
		assertEquals(schedulerService.getAllAppointmentsBasedOnStatusAndUserid("ALL", "PT000").size(), 0);
	}

	@Test
	void testGetAllAppointmentsBasedOnStatusAndUseridForPatientForPendingStatus() {
		when(appointmentRepo.getAllPatientAppointment("PENDING", "PT000")).thenReturn(new ArrayList<>());
		assertEquals(schedulerService.getAllAppointmentsBasedOnStatusAndUserid("PENDING", "PT000").size(), 0);
	}

	@Test
	void testGetAllAppointmentsBasedOnStatusAndUseridForDoctorForAllStatus() {
		when(appointmentRepo.findByDoctorId("DR000")).thenReturn(new ArrayList<>());
		assertEquals(schedulerService.getAllAppointmentsBasedOnStatusAndUserid("ALL", "DR000").size(), 0);
	}

	@Test
	void testGetAllAppointmentsBasedOnStatusAndUseridForDoctorForPendingStatus() {
		when(appointmentRepo.getAllAppointmentRequestForPhysician("PENDING", "DR000")).thenReturn(new ArrayList<>());
		assertEquals(schedulerService.getAllAppointmentsBasedOnStatusAndUserid("PENDING", "DR000").size(), 0);
	}

	@Test
	void testGetAllAppointmentsBasedOnStatusAndUseridForNoUser() {
		assertEquals(schedulerService.getAllAppointmentsBasedOnStatusAndUserid("ALL", "000").size(), 0);
	}

	@Test
	void testChangeStatus() {
		doNothing().when(appointmentRepo).changeStatus("PENDING", 0L);
		schedulerService.changeStatus(new ChangeAppointmentStatusDto(0L, "PENDING"));
	}

	@Test
	void testSendAppointmentRequest() {
		Appointment appointment = new Appointment();
		appointment.setStartTime("2022-07-20T14:30:00.000Z");
		appointment.setPatientId("PT00");
		appointment.setDoctorId("DR00");
		when(appointmentRepo.save(appointment)).thenReturn(appointment);
		schedulerService.sendAppointmentRequest(appointment);
	}

	@Test
	void testDeleteById() {
		doNothing().when(scheduleRepo).deleteById(0L);
		schedulerService.deleteById(0L);
	}

}
