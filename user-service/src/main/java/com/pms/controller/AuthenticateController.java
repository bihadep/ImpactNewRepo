package com.pms.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.dto.ChangePasswordDto;
import com.pms.dto.LoginRequest;
import com.pms.dto.LoginResponse;
import com.pms.dto.SuccessResponse;
import com.pms.dto.TokenRequest;
import com.pms.dto.TokenResponse;
import com.pms.exception.InactiveUserException;
import com.pms.exception.UserNotFoundException;
import com.pms.model.User;
import com.pms.repository.UserRepository;
import com.pms.service.impl.AuthenticationService;
import com.pms.service.impl.UserServiceImpl;
import com.pms.util.JwtUtil;

@RestController
@RequestMapping("/authenticate")
@CrossOrigin
public class AuthenticateController {

	@Autowired
	AuthenticationManager authManager;

	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	AuthenticationService authService;
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	JwtUtil jwtUtil;

	@PostMapping
	public LoginResponse authenticate(@RequestBody LoginRequest request) {
		//CHECKING USER STATUS. IF TRUE THEN LOGIN ELSE NOT.
		User user = userRepo.findByEmailId(request.getUsername());
		if(ObjectUtils.isEmpty(user)) {
			throw new UserNotFoundException("Username "+request.getUsername()+" doest not exist");
		}
		if(user.getStatus()) {
		authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		UserDetails userDetails = userService.loadUserByUsername(request.getUsername());
		String jwtToken = jwtUtil.generateToken(userDetails);
		authService.saveToken(userDetails.getUsername(), jwtToken);
		boolean isPasswordChanged = userRepo.findByEmailId(request.getUsername()).getLogin().getDefaultPassword() == null ? true : false;
		return new LoginResponse(jwtToken, "User authenticated successfully", HttpStatus.OK, isPasswordChanged);
		}else {
			throw new InactiveUserException("Your status is inactive, please contact Admin");
		}
	}
	
	@DeleteMapping("/logout")
	public SuccessResponse logout(HttpServletResponse response) {
		authService.deleteToken(response.getHeader("token"));
		return new SuccessResponse(HttpStatus.OK, "User logout successfully");
	}
	

	@PostMapping("/isValidToken")
	public TokenResponse validateToken(@RequestBody TokenRequest request) {
		TokenResponse response = new TokenResponse();
		String jwtToken = request.getToken();
		String username = jwtUtil.getUsernameFromToken(jwtToken);
		UserDetails userDetails = userService.loadUserByUsername(username);
		boolean isValid = jwtUtil.validateToken(jwtToken, userDetails);
		if (isValid) {
			response.setValid(true);
		} else {
			response.setValid(false);
		}
		return response;
	}
	
	@PostMapping("/changePassword")
	public SuccessResponse changePassword(@RequestBody ChangePasswordDto changePasswordDto) throws Exception {
		authService.changePassword(changePasswordDto);
		return new SuccessResponse(HttpStatus.OK, "Password changed successfully");
	}
	
	@GetMapping("/forgotPassword/{username}")
	public SuccessResponse forgotPassword(@PathVariable("username") String username) {
		authService.forgotPassword(username);
		return new SuccessResponse(HttpStatus.OK, "Default password has been sent on your registered email-Id");
	}
}
