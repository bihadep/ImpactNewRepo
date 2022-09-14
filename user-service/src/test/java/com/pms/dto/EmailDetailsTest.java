package com.pms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmailDetailsTest {

	public EmailDetails getobj() {
		return new EmailDetails();
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
	void testCanEqual() {
		assertTrue(getobj().canEqual(getobj()));
		
	}

	@Test
	void testToString() {
		assertEquals(getobj().toString(), getobj().toString());
	}
	
	@Test
	void testGetRecipient() {
	assertEquals(getobj().getRecipient(), getobj().getRecipient());
	}

	@Test
	void testGetMsgBody() {
		assertEquals(getobj().getMsgBody(), getobj().getMsgBody());
	}

	@Test
	void testGetSubject() {
		assertEquals(getobj().getSubject(), getobj().getRecipient());
	}

	@Test
	void testGetAttachment() {
		assertEquals(getobj().getRecipient(), getobj().getRecipient());
	}

	@Test
	void testSetRecipient() {
		getobj().setRecipient("amit@gmail.com");
		
	}

	@Test
	void testSetMsgBody() {
		getobj().setMsgBody("Hi ");
	}

	@Test
	void testSetSubject() {
		getobj().setSubject("");
	}

	@Test
	void testSetAttachment() {
		getobj().setAttachment("attachmentId");
	}

	

}
