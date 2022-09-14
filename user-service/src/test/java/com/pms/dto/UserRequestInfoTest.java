package com.pms.dto;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class UserRequestInfoTest {

	public UserRequestInfo getobj() {
		return new UserRequestInfo();
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
	void testGetId() {
		assertEquals(getobj().getId(), getobj().getId());
	}

	@Test
	void testGetTitle() {
		assertEquals(getobj().getTitle(), getobj().getTitle());
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
	void testGetEmailId() {
		assertEquals(getobj().getEmailId(), getobj().getEmailId());
	}

	@Test
	void testGetDateOfBirth() {
		assertEquals(getobj().getDateOfBirth(), getobj().getDateOfBirth());
	}

	@Test
	void testGetDateOfJoining() {
		assertEquals(getobj().getDateOfJoining(), getobj().getDateOfJoining());
	}

	@Test
	void testIsStatus() {
		getobj().isStatus();
		
	}

	@Test
	void testGetRoleId() {
		assertEquals(getobj().getRoleId(), getobj().getRoleId());
	}

	@Test
	void testGetEmployeeId() {
		assertEquals(getobj().getEmployeeId(), getobj().getEmployeeId());
	}

	@Test
	void testSetId() {
		getobj().setId(1L);
	}

	@Test
	void testSetTitle() {
		getobj().setTitle("Mr");
	}

	@Test
	void testSetFirstName() {
		getobj().setFirstName("praful");
	}

	@Test
	void testSetLastName() {
		getobj().setLastName("Bihade");
	}

	@Test
	void testSetEmailId() {
		getobj().setEmailId("bihadep@gmail.com");
	}

	@Test
	void testSetDateOfBirth() {
		getobj().setDateOfBirth("02/04/1998");
	}

	@Test
	void testSetDateOfJoining() {
		getobj().setDateOfJoining("05/05/1999");
	}

	@Test
	void testSetStatus() {
		getobj().setStatus(true);
	}

	@Test
	void testSetRoleId() {
		getobj().setRoleId(1L);
	}

	@Test
	void testSetEmployeeId() {
		getobj().setEmployeeId("DR001");
	}

	@Test
	void testCanEqual() {
		assertTrue(getobj().canEqual(getobj()));
	}

	
}
