package com.pms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TokenRequestTest {

	public TokenRequest getobj() {
		return new TokenRequest();
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
	void testToString() {
		assertEquals(getobj().toString(), getobj().toString());
	}
	
	@Test
	void testCanEqual() {
		assertTrue(getobj().canEqual(getobj()));
	}

	
	@Test
	void testGetToken() {
		assertEquals(getobj().getToken(), getobj().getToken());
	}

	@Test
	void testSetToken() {
		getobj().setToken("jwttoken");
	}



}
