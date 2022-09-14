package com.pms.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.pms.dto.UserResponse;

class RoleTest {

	public Role getobj() {
		return new Role();
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
	void testGetRoleId() {
		assertEquals(getobj().getRoleId(), getobj().getRoleId());
	}

	@Test
	void testGetRoleName() {
		assertEquals(getobj().getRoleName(), getobj().getRoleName());
	}

	@Test
	void testSetRoleId() {
		getobj().setRoleId(1L);
	}

	@Test
	void testSetRoleName() {
		getobj().setRoleName("Admin");
	}

	

	@Test
	void testCanEqual() {
		assertTrue(getobj().canEqual(getobj()));
	}

	

}
