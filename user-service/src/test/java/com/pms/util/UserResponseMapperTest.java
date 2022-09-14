package com.pms.util;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.pms.dto.UserResponse;
import com.pms.model.User;

class UserResponseMapperTest {
	
	private UserResponseMapper response = new UserResponseMapper(); 

	
	@Test
	void testMapToUserResponse() {
		List<User> userlist =  new ArrayList();
		assertTrue(response.mapToUserResponse(userlist).size()==0);
		
	}

	@Test
	void testMapToUserResponseUser() {
		
		assertTrue(response.mapToUserResponseUser(new User()) instanceof UserResponse);
		
	}

}
