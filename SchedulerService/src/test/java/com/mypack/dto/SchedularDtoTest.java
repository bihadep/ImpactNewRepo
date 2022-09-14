package com.mypack.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SchedularDtoTest {

	public SchedularDto getObj() {
		return new SchedularDto();
	}
	@Test
	void testHashCode() {
		assertEquals(getObj().hashCode(), getObj().hashCode());
	}

	@Test
	void testGetId() {
		SchedularDto dto = getObj();
		dto.setId(0L);
		assertEquals(dto.getId(), 0L);
	}

	@Test
	void testGetSubject() {
		getObj().getSubject();
	}

	@Test
	void testGetStartTime() {
		getObj().getStartTime();
	}

	@Test
	void testGetEndTime() {
		getObj().getEndTime();
	}

	@Test
	void testGetDescription() {
		getObj().getDescription();
	}

	@Test
	void testIsIsAllDay() {
		getObj().isIsAllDay();
	}

	@Test
	void testGetEmployeeId() {
		getObj().getEmployeeId();
	}

	@Test
	void testGetEmpDbId() {
		getObj().getEmpDbId();
	}

	@Test
	void testSetId() {
		getObj().setId(0L);
	}

	@Test
	void testSetSubject() {
		getObj().setSubject("");
	}

	@Test
	void testSetStartTime() {
		getObj().setStartTime("");
	}

	@Test
	void testSetEndTime() {
		getObj().setEndTime("");
	}

	@Test
	void testSetDescription() {
		getObj().setDescription("");
	}

	@Test
	void testSetIsAllDay() {
		getObj().setIsAllDay(true);
	}

	@Test
	void testSetEmployeeId() {
		getObj().setEmployeeId("0L");
	}

	@Test
	void testSetEmpDbId() {
		getObj().setEmpDbId(0L);
	}

	@Test
	void testEqualsObject() {
		SchedularDto dto = new SchedularDto();
		dto.equals(dto);
		assertTrue(getObj().equals(getObj()));
	}

	@Test
	void testToString() {
		getObj().toString();
	}

	@Test
	void testSchedularDtoLongStringStringStringStringBooleanStringLong() {
		SchedularDto dto = new SchedularDto(0L, "", "", "", "", false, "", 0L);
	}

	@Test
	void testSchedularDto() {
		getObj();
	}

}
