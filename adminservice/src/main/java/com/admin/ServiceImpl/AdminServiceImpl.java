package com.admin.ServiceImpl;

import java.net.URI;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import org.springframework.web.client.RestTemplate;

import com.admin.dto.RegisterUserRequest;
import com.admin.exception.UserNotFoundException;
import com.admin.exception.UserRecordNotFoundException;
import com.admin.model.EmailDetails;
import com.admin.model.SuccessResponse;
import com.admin.model.User;
import com.admin.model.UserResponse;
import com.admin.model.UserUpdateInfo;
import com.admin.service.AdminService;
import com.admin.service.EmailService;
import com.admin.util.Constant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AdminServiceImpl implements AdminService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	EmailService emailService;

	@Autowired
	HttpServletResponse response;

	public HttpHeaders getHeaderWithToken() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + response.getHeader("token"));
		return headers;
	}

	public SuccessResponse registerUser(RegisterUserRequest user) {
		log.info("AdminService >> Inside registerUser method");
		ResponseEntity<SuccessResponse> response = restTemplate.exchange(Constant.USER_SERVICE_BASE_URL + "/user/save",
				HttpMethod.POST, new HttpEntity<>(user, getHeaderWithToken()), SuccessResponse.class);
		log.info("AdminService >> Inside registerUser method >> response from user Service >> {}", response.getBody());
		return response.getBody();
	}

	@Override
	public List<UserResponse> getAllUserByRoleId(Long roleId) throws UserRecordNotFoundException {

		log.debug("inside AdminServiceImpl getAllUser method with input role id: " + roleId);
		if (ObjectUtils.isEmpty(roleId) || roleId == 0)
			throw new UserRecordNotFoundException("Please Provide valid role Id");

		UserResponse[] usarr = null;

		ResponseEntity<UserResponse[]> response = restTemplate.exchange(
				Constant.USER_SERVICE_BASE_URL + "/user/getAllUserByRoleId/" + roleId, HttpMethod.GET,
				new HttpEntity<>(getHeaderWithToken()), UserResponse[].class);

		return Arrays.asList(response.getBody());

	}

	@Override
	public UserResponse getUserByEmployeeId(String employeeId) {

		log.debug("inside AdminServiceImpl getUserByID method with input role id: " + employeeId);
		ResponseEntity<UserResponse> responseEntity = restTemplate.exchange(
				Constant.USER_SERVICE_BASE_URL + "/user/getUserByEmployeeId/" + employeeId, HttpMethod.GET,
				new HttpEntity<>(getHeaderWithToken()), UserResponse.class);
		UserResponse response = null;
		if (ObjectUtils.isEmpty(responseEntity) && ObjectUtils.isEmpty(responseEntity.getBody())) {
			throw new UserNotFoundException("Please provide employee Id in DR001 OR NR001 Format ");
		} else {
			response = responseEntity.getBody();
		}
		return response;

	}

	@Override
	public SuccessResponse updateUser(UserUpdateInfo update) {
		ResponseEntity<User> response = null;
		URI uri = null;
		SuccessResponse successResponse = null;
		try {
			uri = new URI(Constant.USER_SERVICE_BASE_URL + "/user/update");

			log.info("inside AdminServiceImpl getUserByID method with " + update);
			HttpEntity<UserUpdateInfo> httpEntity = new HttpEntity<UserUpdateInfo>(update, getHeaderWithToken());
			response = restTemplate.exchange(uri, HttpMethod.PUT, httpEntity, User.class);
			String message = null;
			if (update.isStatus() == true) {
				message = " Your status has been chnaged from " + Constant.Inactive + " to " + Constant.Active
						+ " Hospital User";
			} else if (update.isStatus() == false) {
				message = " Your status has been chnaged from " + Constant.Active + " to " + Constant.Inactive
						+ " Hospital User";
			}
			String email = response.getBody().getEmailId();
			EmailDetails ed = new EmailDetails();
			ed.setRecipient(email);
			ed.setSubject(" status is updated");
			ed.setMsgBody(message);

			emailService.sendSimpleMail(ed);

			successResponse = new SuccessResponse(HttpStatus.OK, "User Status updated successfully ");

		} catch (URISyntaxException e) {

			log.error("User status updation failed" + e.getMessage());

		}

		return successResponse;

	}

}