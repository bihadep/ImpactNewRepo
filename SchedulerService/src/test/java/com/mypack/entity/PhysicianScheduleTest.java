package com.mypack.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PhysicianScheduleTest {

	
	public PhysicianSchedule getPhysicianScheduleObj(){
		return new  PhysicianSchedule();
	}
	
	@Test
	void testHashCode() {
		PhysicianSchedule schedule = getPhysicianScheduleObj();
		assertEquals(schedule.hashCode(), schedule.hashCode());
	}

	@Test
	void testGetId() {
		PhysicianSchedule schedule = getPhysicianScheduleObj();
		schedule.setId(0L);
		assertEquals(schedule.getId(), 0L);
	}

	@Test
	void testGetSubject() {
		PhysicianSchedule schedule = getPhysicianScheduleObj();
		schedule.setSubject("SUB");
		assertEquals(schedule.getSubject(), "SUB");
	}

	@Test
	void testGetStartTime() {
		PhysicianSchedule schedule = getPhysicianScheduleObj();
		schedule.setStartTime("start");
		assertEquals(schedule.getStartTime(), "start");
	}

	@Test
	void testGetEndTime() {
		PhysicianSchedule schedule = getPhysicianScheduleObj();
		schedule.setEndTime("end");
		assertEquals(schedule.getEndTime(), "end");
	}

	@Test
	void testGetDoctorId() {
		PhysicianSchedule schedule = getPhysicianScheduleObj();
		schedule.setDoctorId(0L);
		assertEquals(schedule.getDoctorId(), 0L);
	}

	@Test
	void testGetEmployeeId() {
		PhysicianSchedule schedule = getPhysicianScheduleObj();
		schedule.setEmployeeId("E");
		assertEquals(schedule.getEmployeeId(), "E");
	}

	@Test
	void testGetDescription() {
		PhysicianSchedule schedule = getPhysicianScheduleObj();
		schedule.setDescription("desc");
		assertEquals(schedule.getDescription(), "desc");
	}

	@Test
	void testSetId() {
		PhysicianSchedule schedule = getPhysicianScheduleObj();
		schedule.setId(0L);
	}

	@Test
	void testSetSubject() {
		PhysicianSchedule schedule = getPhysicianScheduleObj();
		schedule.setSubject("");
	}

	@Test
	void testSetStartTime() {
		PhysicianSchedule schedule = getPhysicianScheduleObj();
		schedule.setStartTime("start");
	}

	@Test
	void testSetEndTime() {
		PhysicianSchedule schedule = getPhysicianScheduleObj();
		schedule.setEndTime("");
	}

	@Test
	void testSetDoctorId() {
		PhysicianSchedule schedule = getPhysicianScheduleObj();
		schedule.setDoctorId(0L);
	}

	@Test
	void testSetEmployeeId() {
		PhysicianSchedule schedule = getPhysicianScheduleObj();
		schedule.setEmployeeId("");
	}

	@Test
	void testSetDescription() {
		PhysicianSchedule schedule = getPhysicianScheduleObj();
		schedule.setDescription("");
	}

	@Test
	void testEqualsObject() {
		PhysicianSchedule schedule = getPhysicianScheduleObj();
		schedule.setStartTime("start");
		assertTrue(schedule.equals(schedule));
	}


	@Test
	void testToString() {
		PhysicianSchedule schedule = getPhysicianScheduleObj();
		schedule.toString();
	}

	@Test
	void testPhysicianScheduleLongStringStringStringLongStringString() {
		PhysicianSchedule schedule = new PhysicianSchedule(0L, "", "", "", 0L, "", "");
	}

	@Test
	void testPhysicianSchedule() {
		PhysicianSchedule schedule = getPhysicianScheduleObj();
	}

}
