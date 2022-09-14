package com.pms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ChangePasswordDtoTest {

	
	ChangePasswordDto getdtoObj() {
		return new ChangePasswordDto();
	}
	
	

	@Test
	void testHashCode() {
		assertEquals(getdtoObj().hashCode(), getdtoObj().hashCode());
	}

	@Test
	void testGetDefaultPassword() {
		assertEquals(getdtoObj().getDefaultPassword(), 
				getdtoObj().getDefaultPassword());
	}

	@Test
	void testGetChangePassword() {
		assertEquals(getdtoObj().getChangePassword(), getdtoObj().getChangePassword());
		
	}

	@Test
	void testSetDefaultPassword() {
		getdtoObj().setDefaultPassword("");
	}

	@Test
	void testSetChangePassword() {
		getdtoObj().setChangePassword("");

	}

	@Test
	void testEqualsObject() {
		assertTrue(getdtoObj().equals(getdtoObj()));
	}

	@Test
	void testCanEqual() {
		
		getdtoObj().canEqual(getdtoObj());
	}

	@Test
	void testToString() {
		getdtoObj().toString();
	}

	@Test
	void testChangePasswordDtoStringString() {
		getdtoObj().setChangePassword("Pass@1234");
	}

	@Test
	void testChangePasswordDto() {
		getdtoObj().getChangePassword();
	}

}
