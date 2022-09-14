package com.mypack.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TimeslotDtoTest {
	
	public TimeslotDto getObj() {
		return new TimeslotDto();
	}

	@Test
	void testHashCode() {
		assertEquals(getObj().hashCode(), getObj().hashCode());
	}

	@Test
	void testGetId() {
		TimeslotDto dto = getObj();
		dto.setId(0L);
		assertEquals(dto.getId(), 0L);
	}

	@Test
	void testGetDate() {
		TimeslotDto dt = getObj();
		dt.setDate("date");
		assertEquals(dt.getDate(), "date");
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
	void testSetId() {
		getObj().setId(0L);
	}

	@Test
	void testSetDate() {
		getObj().setDate("");
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
	void testEqualsObject() {
		TimeslotDto dto = new TimeslotDto();
		dto.equals(dto);
		assertTrue(getObj().equals(getObj()));
	}

	@Test
	void testToString() {
		getObj().toString();
	}

	@Test
	void testTimeslotDtoLongStringStringString() {
		TimeslotDto dto = new TimeslotDto(0L, "", "", "");
	}

	@Test
	void testTimeslotDto() {
		getObj();
	}

}
