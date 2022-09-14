package com.mypack.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ChangeAppointmentStatusDtoTest {
	
	public ChangeAppointmentStatusDto getObj() {
		return new ChangeAppointmentStatusDto();
	}

	@Test
	void testHashCode() {
		assertEquals(getObj().hashCode(), getObj().hashCode());
	}

	@Test
	void testGetId() {
		getObj().getId();
	}

	@Test
	void testGetStatus() {
		ChangeAppointmentStatusDto dto = getObj();
		dto.setStatus("s");
		assertEquals(dto.getStatus(), "s");
	}

	@Test
	void testSetId() {
		getObj().setId(0L);
	}

	@Test
	void testSetStatus() {
		getObj().setStatus("");
	}

	@Test
	void testEqualsObject() {
		assertTrue(getObj().equals(getObj()));
	}


	@Test
	void testToString() {
		getObj().toString();
	}

	@Test
	void testChangeAppointmentStatusDtoLongString() {
		ChangeAppointmentStatusDto dto = new ChangeAppointmentStatusDto(0L, "");
	}

	@Test
	void testChangeAppointmentStatusDto() {
		getObj();
	}

}
