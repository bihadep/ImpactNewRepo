package com.pms.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConstantsTest {

	@Test
	public void testPhy() {
		Constants constant = new Constants();
		assertEquals("DR", Constants.phyEmpId);
	}
	
	@Test
	public void testNurse() {
		Constants constant = new Constants();
		assertEquals("NR", Constants.NurseEmpId);
	}
	
	

}
