package com.pms.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginRequestTest {

	
	public LoginRequest getobj() {
		return new LoginRequest();
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
	void testGetUsername() {
		assertEquals(getobj().getUsername(), getobj().getUsername());
	}

	@Test
	void testGetPassword() {
		assertEquals(getobj().getPassword(), getobj().getPassword());
	}

	@Test
	void testSetUsername() {
		getobj().setUsername("Prfaul");
	}

	@Test
	void testSetPassword() {
		getobj().setPassword("Newpwd@123");
	}



}
