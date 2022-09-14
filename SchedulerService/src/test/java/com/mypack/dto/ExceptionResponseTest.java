package com.mypack.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class ExceptionResponseTest {
	
	ExceptionResponse getObj() {
		return new ExceptionResponse();
	}

	@Test
	void testHashCode() {
		assertEquals(getObj().hashCode(), getObj().hashCode());
	}

	@Test
	void testGetTimestamp() {
		getObj().getTimestamp();
	}

	@Test
	void testGetMessage() {
		ExceptionResponse response = getObj();
		response.setMessage("no");
		assertEquals(response.getMessage(), "no");
	}

	@Test
	void testGetHttpStatus() {
		ExceptionResponse response = getObj();
		response.setHttpStatus(HttpStatus.OK);
		assertEquals(response.getHttpStatus(), HttpStatus.OK);
	}

	@Test
	void testSetTimestamp() {
		getObj().setTimestamp(new Date());
	}

	@Test
	void testSetMessage() {
		getObj().setMessage("");
	}

	@Test
	void testSetHttpStatus() {
		getObj().setHttpStatus(HttpStatus.OK);
	}

	@Test
	void testEqualsObject() {
		getObj().equals(getObj());
	}

	@Test
	void testToString() {
		getObj().toString();
	}

	@Test
	void testExceptionResponse() {
		getObj();
	}

	@Test
	void testExceptionResponseDateStringHttpStatus() {
		ExceptionResponse response = new ExceptionResponse(new Date(), "", HttpStatus.OK);
	}

}
