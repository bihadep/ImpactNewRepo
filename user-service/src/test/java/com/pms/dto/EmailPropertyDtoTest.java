package com.pms.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailPropertyDtoTest {

	
	public EmailPropertyDto getobj() {
		return new EmailPropertyDto();
	}

	@Test
	void testHashCode() {
		assertEquals(getobj().hashCode(), getobj().hashCode());
	}
	
	@Test
	void testEqualsObject() {
		assertEquals(getobj(), getobj());
	}

	@Test
	void testCanEqual() {
		assertTrue(getobj().canEqual(getobj()));
		
	}

	@Test
	void testToString() {
		assertEquals(getobj().toString(), getobj().toString());
	}

	@Test
	void testGetEmailId() {
		assertEquals(getobj().getEmailId(), getobj().getEmailId());
	}

	@Test
	void testSetEmailId() {
		getobj().setEmailId("bihadep@gmail.com");
	}

	
}
