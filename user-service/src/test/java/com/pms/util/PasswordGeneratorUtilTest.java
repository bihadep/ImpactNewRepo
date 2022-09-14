package com.pms.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordGeneratorUtilTest {

	PasswordGeneratorUtil  getObj() {
		return new PasswordGeneratorUtil();
	}
	
	
	@Test
	void testGenerateDefaultPassword() {
		assertTrue(getObj().generateDefaultPassword() instanceof String);
	}

}
