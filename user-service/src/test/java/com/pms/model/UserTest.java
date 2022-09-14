package com.pms.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.pms.dto.UserResponse;

class UserTest {

	public User getobj() {
		return new User();
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
	void testGetStatus() {
		assertEquals(getobj().getStatus(), getobj().getStatus());
	}

	@Test
	void testGetLogin() {
		Login login = new Login();
		assertEquals(login, login);
	}

	@Test
	void testGetEmployeeId() {
		assertEquals(getobj().getEmployeeId(), getobj().getEmployeeId());	
	}

	@Test
	void testGetSpecialization() {
		assertEquals(getobj().getSpecialization(), getobj().getSpecialization());
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
		getobj().setFirstName("Praful");
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
		getobj().setDateOfBirth("02/03/2002");
	}

	@Test
	void testSetDateOfJoining() {
		getobj().setDateOfJoining("02/05/2002");
	}

	@Test
	void testSetStatus() {
		getobj().setStatus(true);
	}

	@Test
	void testSetLogin() {
		Login login = new Login();
		getobj().setLogin(login);
	}

	@Test
	void testSetEmployeeId() {
		getobj().setEmployeeId("DR001");
	}

	@Test
	void testSetSpecialization() {
		getobj().setSpecialization("Ortho");
	}

	

	@Test
	void testCanEqual() {
		assertTrue(getobj().canEqual(getobj()));
	}

	

}
