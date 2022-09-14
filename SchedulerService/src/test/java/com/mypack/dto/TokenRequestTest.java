package com.mypack.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TokenRequestTest {

	public TokenRequest getObj() {
		return new TokenRequest();
	}	
	
	@Test
	void testHashCode() {
		assertEquals(getObj().hashCode(), getObj().hashCode());
	}

	@Test
	void testGetToken() {
		TokenRequest req = getObj();
		req.setToken("token");
		assertEquals(req.getToken(), "token");
	}

	@Test
	void testSetToken() {
		getObj().setToken("token");
	}

	@Test
	void testEqualsObject() {
		assertTrue(getObj().equals(getObj()));
	}

	@Test
	void testToString() {
		assertTrue(getObj().toString() instanceof String);
	}

	@Test
	void testTokenRequestString() {
		TokenRequest request = new TokenRequest("");
	}

	@Test
	void testTokenRequest() {
		getObj();
	}

}
