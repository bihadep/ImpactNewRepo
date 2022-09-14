package com.pms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class TokenResponseTest {
	
	public TokenResponse getobj() {
		return new TokenResponse();
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
	void testIsValid() {
		getobj().isValid();
	}

	@Test
	void testSetValid() {
		getobj().setValid(true);
	}

	
	@Test
	void testCanEqual() {
		fail("Not yet implemented"); // TODO
	}

}
