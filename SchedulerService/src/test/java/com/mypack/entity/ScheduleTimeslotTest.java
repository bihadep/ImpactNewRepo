package com.mypack.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ScheduleTimeslotTest {
	
	public ScheduleTimeslot getScheduleTimeslotObj() {
		return new ScheduleTimeslot();
	}

	@Test
	void testHashCode() {
		ScheduleTimeslot timeslot = getScheduleTimeslotObj();
		assertEquals(timeslot.hashCode(), timeslot.hashCode());
	}

	@Test
	void testGetId() {
		ScheduleTimeslot timeslot = getScheduleTimeslotObj();
		timeslot.getId();
	}

	@Test
	void testGetStartTime() {
		ScheduleTimeslot timeslot = getScheduleTimeslotObj();
		timeslot.getStartTime();
	}

	@Test
	void testGetEndTime() {
		ScheduleTimeslot timeslot = getScheduleTimeslotObj();
		timeslot.getEndTime();
	}

	@Test
	void testGetScheduleId() {
		ScheduleTimeslot timeslot = getScheduleTimeslotObj();
		timeslot.getScheduleId();
	}

	@Test
	void testGetStatus() {
		ScheduleTimeslot timeslot = getScheduleTimeslotObj();
		timeslot.getStatus();
	}

	@Test
	void testSetId() {
		getScheduleTimeslotObj().setId(0L);
	}

	@Test
	void testSetStartTime() {
		getScheduleTimeslotObj().setStartTime("start");
	}

	@Test
	void testSetEndTime() {
		getScheduleTimeslotObj().setEndTime("");
	}

	@Test
	void testSetScheduleId() {
		getScheduleTimeslotObj().setScheduleId(0L);
	}

	@Test
	void testSetStatus() {
		getScheduleTimeslotObj().setStatus("");
	}

	@Test
	void testEqualsObject() {
		getScheduleTimeslotObj().equals(getScheduleTimeslotObj());
	}


	@Test
	void testToString() {
		getScheduleTimeslotObj().toString();
	}

	@Test
	void testScheduleTimeslotLongStringStringLongString() {
		ScheduleTimeslot timelsot = new ScheduleTimeslot(0L, "", "", 0L, "");
	}

	@Test
	void testScheduleTimeslot() {
		getScheduleTimeslotObj();
	}

}
