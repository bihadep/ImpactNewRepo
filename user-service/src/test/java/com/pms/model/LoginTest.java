package com.pms.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pms.dto.UserResponse;

class LoginTest {

	public Login getobj() {
		return new Login();
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
	void testGetLoginId() {
		assertEquals(getobj().getLoginId(), getobj().getLoginId());
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
	void testGetDefaultPassword() {
		assertEquals(getobj().getDefaultPassword(), getobj().getDefaultPassword());
	}

	@Test
	void testGetRoleId() {
		assertEquals(getobj().getRoleId(), getobj().getRoleId());
	}

	@Test
	void testGetToken() {
		assertEquals(getobj().getToken(), getobj().getToken());
	}

	@Test
	void testSetLoginId() {
		getobj().setLoginId(1L);
	}

	@Test
	void testSetUsername() {

		getobj().setUsername("bihade@gmail.com");
	}

	@Test
	void testSetPassword() {
		getobj().setPassword("password@123");
	}

	@Test
	void testSetDefaultPassword() {
		getobj().setDefaultPassword("password@123");
	}

	@Test
	void testSetRoleId() {
		getobj().setRoleId(1L);
	}

	@Test
	void testSetToken() {
		getobj().setToken("jwttoken");
	}

	
	@Test
	void testCanEqual() {
		assertTrue(getobj().canEqual(getobj()));
	}

	


}
