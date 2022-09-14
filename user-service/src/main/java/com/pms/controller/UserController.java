package com.pms.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.dto.EmailPropertyDto;
import com.pms.dto.SuccessResponse;
import com.pms.dto.UpdateUser;
import com.pms.dto.UserCountDto;
import com.pms.dto.UserResponse;
import com.pms.model.Role;
import com.pms.model.User;
import com.pms.service.impl.UserServiceImpl;
import com.pms.vo.UserRequestInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@GetMapping("/getAllUserByRoleId/{id}")
	public List<UserResponse> getAllUserByRoleId(@PathVariable("id") long roleId) {

		log.debug("inside user getAllUserByRoleId Api" + roleId);
		return userService.getAllUserByRoleId(roleId);

	}

	@GetMapping("/getUserByEmployeeId/{employeeid}")
	public UserResponse getUserByEmployeeId(@PathVariable("employeeid") String employeeid) {

		log.debug("inside user getAllUserByEmployeeId Api" + employeeid);
		return userService.getUserByID(employeeid);

	}

	@PostMapping("/save")
	public SuccessResponse saveUser(@RequestBody UserRequestInfo userDto) {
		userService.saveUser(userDto);
		log.debug("inside user saveUser Api" + userDto);
		return new SuccessResponse(HttpStatus.OK, "User Registered Successfully");
	}
	
	@PostMapping("/savePatient")
	public SuccessResponse savePatient(@RequestBody UserRequestInfo userDto) {
		userService.saveUser(userDto);
		log.debug("inside user savePatient Api" + userDto);
		return new SuccessResponse(HttpStatus.OK, "Patient Registered Successfully");
	}

	@PutMapping("/update")
	public User updateUser(@RequestBody UpdateUser updateUser) {
		log.debug("inside user updateUser Api" + updateUser);
		return userService.updateUser(updateUser);
	}
	
	//FOR PATIENT USE
	@PutMapping("/updateDefaultPasswordToNull")
	public SuccessResponse updateDefaultPasswordToNull(@RequestBody EmailPropertyDto dto) {
		userService.changeDefaultPasswordToNull(dto.getEmailId());
		return new SuccessResponse(HttpStatus.OK, "Default Password Changed");
	}

	@GetMapping("/getAllUser")
	public ResponseEntity<List<UserResponse>> getAllUser() {

		List<UserResponse> list = userService.getAllUsers();
		log.info("inside user getAllUser Api");

		return ResponseEntity.ok(list);
	}

	@GetMapping("/getAllUserwithlogin")
	public ResponseEntity<List<User>> getAllUserWithLogin() {

		List<User> list = userService.getAllUserWithLogin();
		log.info("inside user getAllUserWithLogin Api");
		return ResponseEntity.ok(list);
	}

	@GetMapping("/getAllRoles")
	public List<Role> getAllRoles(){
		return userService.getAllRoles();
	}
	
	@GetMapping("/getAllUserCount")
	public UserCountDto getAllUserCount() {
		return userService.countUser();
	}
	
	@GetMapping("/getPhysicianDetails")
	public List<User> getPhysicianDetails(){
		return userService.getPhysicianDetails();
	}
}
