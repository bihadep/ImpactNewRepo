package com.admin.service;

import java.util.List;

import com.admin.dto.RegisterUserRequest;
import com.admin.model.SuccessResponse;
import com.admin.model.UserResponse;

import com.admin.model.UserUpdateInfo;

public interface AdminService {

	List<UserResponse> getAllUserByRoleId(Long role) throws Exception;

	UserResponse getUserByEmployeeId(String employeeId);

	SuccessResponse updateUser(UserUpdateInfo update);
	
	public SuccessResponse registerUser(RegisterUserRequest user);

}
