package com.pms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UpdateUserTest {

	public UpdateUser getobj() {
		return new UpdateUser();
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
	void testGetEmployeeId() {
		assertEquals(getobj().getEmployeeId(), getobj().getEmployeeId());
	}

	@Test
	void testSetEmployeeId() {
		getobj().setEmployeeId("DR001");
	}
	
	@Test
	void testIsStatus() {
		getobj().isStatus();

	}

	@Test
	void testGetPassword() {
		assertEquals(getobj().getEmployeeId(), getobj().getEmployeeId());
	}


	@Test
	void testSetStatus() {
		getobj().setStatus(true);
	}

	@Test
	void testSetPassword() {
		getobj().setPassword("pass@123");
	}

	@Test
	void testCanEqual() {
		assertTrue(getobj().canEqual(getobj()));
	}
}