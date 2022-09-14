package com.pms.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pms.dto.EmailPropertyDto;
import com.pms.dto.SuccessResponse;
import com.pms.dto.UpdateUser;
import com.pms.dto.UserCountDto;
import com.pms.dto.UserResponse;
import com.pms.model.Login;
import com.pms.model.Role;
import com.pms.model.User;
import com.pms.service.impl.UserServiceImpl;
import com.pms.vo.UserRequestInfo;

@ExtendWith(MockitoExtension.class)
class UserControllerTest 	{

	@Mock
	private UserServiceImpl  userServiceImpl;

	@InjectMocks
	private UserController  userController;

	Login login ,login2;	
	User user;	
	UserRequestInfo  requestInfo;
	List<Role> roleList;
	UpdateUser updateUser;

	List<UserResponse> userResponsesList;
	List<User> usersList;
	UserResponse userResponse;
	


	@BeforeEach
	void setUp() {

		login = new Login(1L, "bihadep@gmail.com", "", "password@123", 1L, "");
		login2 = new Login(2L, "amitk@gmail.com", "", "amit@123", 1L, "");
		updateUser = new UpdateUser("DR001", false, "Password@123");
		user = new User(1L, "Mr", "Praful", "bihade", "bihadep@gmail.com", "06/05/1998", "06/03/2022", true, login, "DR001", "Ortho");
		//requestInfo = new UserRequestInfo(1L, "Mr", "praful", "bihade", "bihadep@gmail.com", "06/05/1997", "06/03/2022", true, 1L, "DR001","Ortho");
		userResponsesList = new ArrayList<>();
		userResponsesList.add(new UserResponse("DR001", "Praful", "Bihade", true, "05/02/2021", "Ortho"));
		userResponsesList.add(new UserResponse("DR002", "Amit", "kolhe", true, "07/06/2021", "Ortho"));

		usersList = new ArrayList<>();
		usersList.add(new User(1L, "Mr", "praful", "bihade", "bihadep@gmail.com", "06/05/1998", "06/03/2022", true, login, "DR001","Ortho"));
		usersList.add(new User(2L, "Mr", "Amit", "kolhe", "amitk@gmail.com", "06/05/1995", "07/03/2022", true,login, "DR002","Ortho"));


		Role r1 = new Role(1L, "Admin");
		Role r2 = new Role(2L, "Physician");
		Role r3 = new Role(3L, "Nurse");
		Role r4 = new Role(4L, "Patient");

		roleList = new ArrayList<>();
		roleList.add(r1);
		roleList.add(r2);
		roleList.add(r3);
		roleList.add(r4);

	}



	@Test
	void testGetAllUserByRoleId() {
		when(userServiceImpl.getAllUserByRoleId(1L)).thenReturn(userResponsesList);
		assertTrue(userController.getAllUserByRoleId(1L).size() == 2);
		
	}
	@Test
	void testGetUserByEmployeeId()  {
		UserResponse response = new UserResponse();
		
		when(userServiceImpl.getUserByID("DR001")).thenReturn(response);
		assertTrue(userController.getUserByEmployeeId("DR001") instanceof UserResponse);
	}

	

	@Test
	void testSaveUser() {
		when(userServiceImpl.saveUser(requestInfo)).thenReturn(user);
		
		assertTrue(userController.saveUser(requestInfo) instanceof SuccessResponse);
	}

	@Test
	void testSavePatient() {
		when(userServiceImpl.saveUser(requestInfo)).thenReturn(user);
		
		assertTrue(userController.savePatient(requestInfo) instanceof SuccessResponse);
	}

	@Test
	void testUpdateUser() {
		when(userServiceImpl.updateUser(updateUser)).thenReturn(user);
		assertTrue(userController.updateUser(updateUser) instanceof User);
		
	}

	@Test
	void testUpdateDefaultPasswordToNull() {

	assertTrue(userController.updateDefaultPasswordToNull(
			new EmailPropertyDto()) instanceof SuccessResponse);
	}

	@Test
	void testGetAllUser() {
		when(userServiceImpl.getAllUsers()).thenReturn(userResponsesList);
		assertTrue(userController.getAllUser().getBody().size()==2);
	}

	@Test
	void testGetAllUserWithLogin() {
		when(userServiceImpl.getAllUserWithLogin()).thenReturn(usersList);
		assertTrue(userController.getAllUserWithLogin().getBody().size()==2);
	}

	@Test
	void testGetAllRoles() {
		when(userServiceImpl.getAllRoles()).thenReturn(roleList);
		assertTrue(userController.getAllRoles().size()==4);
		
	}

	@Test
	void testGetAllUserCount() {
		when(userServiceImpl.countUser()).thenReturn(new UserCountDto());
		assertTrue(userController.getAllUserCount() instanceof UserCountDto);
	}

	@Test
	void testGetPhysicianDetails() {
		when(userServiceImpl.getPhysicianDetails()).thenReturn(usersList);
		assertTrue(userController.getPhysicianDetails().size()==2);
	}
}