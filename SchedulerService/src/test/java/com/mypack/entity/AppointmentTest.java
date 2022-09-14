package com.mypack.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AppointmentTest {
	
	public Appointment getAppointmentObj() {
		return new Appointment();
	}
	
	@Test
	void testHashCode() {
		Appointment app = getAppointmentObj();
		assertEquals(app.hashCode(), app.hashCode());
	}

	@Test
	void testGetId() {
		Appointment app = getAppointmentObj();
		app.setId(0L);
		assertEquals(app.getId(), 0L);
	}

	@Test
	void testGetStartTime() {
		Appointment app = getAppointmentObj();
		app.setStartTime("time");
		assertEquals(app.getStartTime(), "time");
	}

	@Test
	void testGetDoctorId() {
		Appointment app = getAppointmentObj();
		app.setDoctorId("DR");
		assertEquals(app.getDoctorId(), "DR");
	}

	@Test
	void testGetPatientId() {
		Appointment app = getAppointmentObj();
		app.setPatientId("PT");
		assertEquals(app.getPatientId(), "PT");
	}

	@Test
	void testGetStatus() {
		Appointment app = getAppointmentObj();
		app.setStatus("PENDING");
		assertEquals(app.getStatus(), "PENDING");
	}

	@Test
	void testSetId() {
		Appointment app = getAppointmentObj();
		app.setId(0L);
	}

	@Test
	void testSetStartTime() {
		Appointment app = getAppointmentObj();
		app.setStartTime("");
	}

	@Test
	void testSetDoctorId() {
		Appointment app = getAppointmentObj();
		app.setDoctorId("");
	}

	@Test
	void testSetPatientId() {
		Appointment app = getAppointmentObj();
		app.setPatientId("");
	}

	@Test
	void testSetStatus() {
		Appointment app = getAppointmentObj();
		app.setStatus("");
	}

	@Test
	void testEqualsObject() {
		Appointment app = getAppointmentObj();
		assertTrue(app.equals(app));
	}

	@Test
	void testCanEqual() {
		Appointment app = getAppointmentObj();
		app.canEqual(app);
	}

	@Test
	void testToString() {
		Appointment app = getAppointmentObj();
		app.toString();
	}

	@Test
	void testAppointmentLongStringStringStringString() {
		Appointment app = new Appointment(0L, "", "", "", "");
		
	}

	@Test
	void testAppointment() {
		Appointment app = getAppointmentObj();
	}

}
