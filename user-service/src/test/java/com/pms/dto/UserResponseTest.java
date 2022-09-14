package com.pms.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserResponseTest {

	
	public UserResponse getobj() {
		return new UserResponse();
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
	void testGetFirstName() {
		assertEquals(getobj().getFirstName(), getobj().getFirstName());
	}

	@Test
	void testGetLastName() {
		assertEquals(getobj().getLastName(), getobj().getLastName());
	}

	@Test
	void testGetStatus() {
		assertEquals(getobj().getStatus(), getobj().getStatus());
	}

	@Test
	void testGetDateOfJoining() {
		assertEquals(getobj().getDateOfJoining(), getobj().getDateOfJoining());
	}

	@Test
	void testGetSpecialist() {
		assertEquals(getobj().getSpecialist(), getobj().getSpecialist());
	}

	@Test
	void testSetEmployeeId() {
		assertEquals(getobj().getEmployeeId(), getobj().getEmployeeId());
	}

	@Test
	void testSetFirstName() {
		getobj().setFirstName("praful");
	}

	@Test
	void testSetLastName() {
		getobj().setLastName("BIhade");
	}

	@Test
	void testSetStatus() {
		getobj().setStatus(true);
	}

	@Test
	void testSetDateOfJoining() {
		getobj().setDateOfJoining("02/05/2002");
	}

	@Test
	void testSetSpecialist() {
		getobj().setSpecialist("Ortho");
	}

	

	@Test
	void testCanEqual() {
		assertTrue(getobj().canEqual(getobj()));
	}

}
