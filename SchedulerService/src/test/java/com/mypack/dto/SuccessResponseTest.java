package com.mypack.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class SuccessResponseTest {

	public SuccessResponse getObj() {
		return new SuccessResponse();
	}
	
	@Test
	void testHashCode() {
		assertEquals(getObj().hashCode(), getObj().hashCode());
	}

	@Test
	void testGetMessage() {
		SuccessResponse res = getObj();
		res.setMessage("message");
		assertEquals("message", res.getMessage());
	}

	@Test
	void testGetHttpStatus() {
		SuccessResponse res = getObj();
		res.setHttpStatus(HttpStatus.OK);
		assertEquals(HttpStatus.OK, res.getHttpStatus());
	}

	@Test
	void testSetMessage() {
		getObj().setMessage("message");
	}

	@Test
	void testSetHttpStatus() {
		getObj().setHttpStatus(HttpStatus.OK);
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
	void testSuccessResponseStringHttpStatus() {
		SuccessResponse res = new SuccessResponse("message", HttpStatus.OK);
	}

	@Test
	void testSuccessResponse() {
		getObj();
	}

}
