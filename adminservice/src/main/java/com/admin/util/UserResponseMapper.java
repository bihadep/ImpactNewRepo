package com.admin.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.admin.model.User;
import com.admin.model.UserResponse;


@Component
public class UserResponseMapper {



	public List<UserResponse> mapToUserResponse(List<User> dbuserList){

		List<UserResponse>  userRespList = new ArrayList<>();
		for (User userdb : dbuserList) {
			UserResponse userResp = new UserResponse();
			userResp.setFirstName(userdb.getFirstName());
			userResp.setLastName(userdb.getLastName());
			userResp.setEmployeeId(userdb.getEmployeeId());
			userResp.setDateOfJoining(userdb.getDateOfJoining());
			userResp.setStatus(userdb.getStatus());
			userRespList.add(userResp);
		}

		return userRespList;
	}

	public  UserResponse mapToUserResponseUser (User userdb){

		UserResponse userResp = new UserResponse();
		userResp.setFirstName(userdb.getFirstName());
		userResp.setLastName(userdb.getLastName());
		userResp.setEmployeeId(userdb.getEmployeeId());
		userResp.setDateOfJoining(userdb.getDateOfJoining());
		userResp.setStatus(userdb.getStatus());

		return userResp;


	}

}