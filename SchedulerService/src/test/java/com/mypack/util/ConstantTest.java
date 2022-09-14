package com.mypack.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ConstantTest {

//	@InjectMocks
//	Constant constant;
	
	
	
	@Test
	public void test() {
		Constant constant = new Constant();
		assertEquals("APPROVED", Constant.APPOINEMENT_APPROVED);
	}
	
	@Test
	public void testPending() {
		assertEquals("PENDING", Constant.APPOINEMENT_PENDING);
	}
	
	@Test
	public void testRejected() {
		assertEquals("REJECTED", Constant.APPOINEMENT_REJECT);
	}

}
	