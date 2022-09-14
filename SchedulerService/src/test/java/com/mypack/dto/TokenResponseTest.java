package com.mypack.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TokenResponseTest {
	public TokenResponse getObj() {
		return new TokenResponse();
	}
	
	@Test
	void testHashCode() {
		assertEquals(getObj().hashCode(), getObj().hashCode());
	}

	@Test
	void testIsValid() {
		TokenResponse res = getObj();
		res.setValid(false);
		assertEquals(res.isValid(), false);
	}

	@Test
	void testSetValid() {
		getObj().setValid(false);
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
	void testTokenResponseBoolean() {
		TokenResponse res = new TokenResponse(false);
	}

	@Test
	void testTokenResponse() {
		getObj();
	}

}
