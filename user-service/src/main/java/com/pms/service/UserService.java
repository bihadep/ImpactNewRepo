package com.pms.service;

import java.util.List;

import com.pms.dto.UpdateUser;
import com.pms.vo.UserRequestInfo;
import com.pms.dto.UserResponse;
import com.pms.model.Role;
import com.pms.model.User;

public interface UserService {
	
	User saveUser(UserRequestInfo User);
	
	User  getUser(Long UserId);

	User updateUser(UpdateUser user);
	
	List<UserResponse> getAllUsers();
	
	List<User> getAllUserWithLogin();

	List<UserResponse> getAllUserByRoleId(long roleId);

	UserResponse getUserByID(String employeeid);
	
	public List<Role> getAllRoles();
	
	public User getUserFromToken(String jwtToken);

	public User getUserByEmailId(String emailId);
	
	public List<User> getPhysicianDetails();

}
