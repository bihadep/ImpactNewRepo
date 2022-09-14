package com.pms.dto;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class LoginResponseTest {

	public LoginResponse getobj() {
		return new LoginResponse();
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
	void testGetToken() {
		assertEquals(getobj().getToken(), getobj().getToken());
		
	}

	@Test
	void testGetMessage() {
		assertEquals(getobj().getMessage(), getobj().getMessage());
	}

	@Test
	void testGetStatus() {
		assertEquals(getobj().getMessage(), getobj().getMessage());
	}

	@Test
	void testIsPasswordChanged() {
		when(getobj().isPasswordChanged()).thenReturn(true);
		assertTrue(getobj().isPasswordChanged());
	}

	@Test
	void testSetToken() {
		getobj().setToken("token");
		
	}

	@Test
	void testSetMessage() {
		getobj().setMessage("msg");
	}

	@Test
	void testSetStatus() {
		getobj().setStatus(HttpStatus.OK);
	}

	@Test
	void testSetPasswordChanged() {
				getobj().setPasswordChanged(true);
	}

	

}
