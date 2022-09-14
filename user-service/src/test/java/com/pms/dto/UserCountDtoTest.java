package com.pms.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserCountDtoTest {

	
	public UserCountDto getobj() {
		return new UserCountDto();
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
	void testGetPhysicianCount() {
		assertEquals(getobj().getPhysicianCount(), getobj().getPhysicianCount());
	}

	@Test
	void testGetNurseCount() {
		assertEquals(getobj().getNurseCount(), getobj().getNurseCount());
	}

	@Test
	void testGetPatientCount() {
		assertEquals(getobj().getPatientCount(), getobj().getPatientCount());
	}

	@Test
	void testSetPhysicianCount() {
		getobj().setPhysicianCount(2L);
	}

	@Test
	void testSetNurseCount() {
		getobj().setNurseCount(4L);
	}

	@Test
	void testSetPatientCount() {
		getobj().setPatientCount(2L);
	}

	

	@Test
	void testCanEqual() {
		assertTrue(getobj().canEqual(getobj()));
	}

}
