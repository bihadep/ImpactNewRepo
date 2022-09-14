package com.pms.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class ExceptionResponseDtoTest {

	
	public ExceptionResponseDto getobj() {
		return new ExceptionResponseDto();
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
	void testGetTimestamp() {
		assertEquals(getobj().getTimestamp(), getobj().getTimestamp());
	}

	@Test
	void testGetMessage() {
		assertEquals(getobj().getMessage(), getobj().getMessage());
	}

	@Test
	void testGetHttpStatus() {
		assertEquals(getobj().getHttpStatus(), getobj().getHttpStatus());	}

	@Test
	void testSetTimestamp() {
		getobj().setHttpStatus(HttpStatus.OK);
	}

	@Test
	void testSetMessage() {

	getobj().setMessage("");
	
	}

	

	
}
