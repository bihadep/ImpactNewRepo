package com.pms.util;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pms.model.User;
import com.pms.vo.UserRequestInfo;


@ExtendWith(MockitoExtension.class)
class UserRequestInfoMapperTest {

	@Mock
	private PasswordGeneratorUtil generatorUtil;
	
	
	@InjectMocks
	private UserRequestInfoMapper infoMapper;
	//= new UserRequestInfoMapper();
	
	
	@Test
	void testMapRequestToUser() {
		
		 UserRequestInfo requestInfo = new UserRequestInfo(1L, "Mr", "praful", "bihade", "bihadep@gmail.com", "06/05/1997", "06/03/2022", true, 1L,"password@123", "DR001","Ortho");
		 //when(requestInfo.getRoleId()).thenReturn(1L);
		 //when(generatorUtil.generateDefaultPassword()).thenReturn("password@123");
		when(infoMapper.mapRequestToUser(requestInfo)).thenReturn(new User());
		assertTrue(infoMapper.mapRequestToUser(new UserRequestInfo()) instanceof User);
	}

}
