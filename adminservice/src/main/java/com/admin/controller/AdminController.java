package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.dto.RegisterUserRequest;
import com.admin.model.SuccessResponse;
import com.admin.model.UserResponse;
import com.admin.model.UserUpdateInfo;
import com.admin.service.AdminService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/admin/user")
public class AdminController {

	@Autowired
	AdminService adminService;

	@GetMapping("/getAllUserByRoleId/{id}")
	public List<UserResponse> getAllUserByRoleId(@PathVariable("id") long roleId) throws Exception {
		log.debug("inside admin getAllUserByRoleId API " + roleId);
		return adminService.getAllUserByRoleId(roleId);
	}

	@PutMapping("/update")
	public SuccessResponse updateUser(@RequestBody UserUpdateInfo updateInfo) {
		log.debug("inside admin updateUser API " + updateInfo);
		return adminService.updateUser(updateInfo);
	}
	
	@PostMapping("/registerUser")
	public SuccessResponse registerUser(@RequestBody RegisterUserRequest request) {
		log.debug("Admin controller >> registerUser method");
		return adminService.registerUser(request);
	}

	@GetMapping("/getAllUserByEmployeeId/{employeeid}")
	public UserResponse getAllUserByEmployeeId(@PathVariable("employeeId") String employeeId) {
		log.debug("inside admin getAllUserByEmployeeId API ");
		return adminService.getUserByEmployeeId(employeeId);
	}

}
