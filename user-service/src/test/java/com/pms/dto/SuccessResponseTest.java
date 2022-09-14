package com.pms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class SuccessResponseTest {

	
	public SuccessResponse getobj() {
		return new SuccessResponse();
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
	void testGetHttpStatus() {
		assertEquals(getobj().getHttpStatus(), getobj().getHttpStatus());
	}

	@Test
	void testGetMessage() {
		assertEquals(getobj().getHttpStatus(), getobj().getHttpStatus());
	}

	@Test
	void testSetHttpStatus() {
		getobj().setHttpStatus(HttpStatus.OK);
	}

	@Test
	void testSetMessage() {
		getobj().setMessage("msg");
	}



}
