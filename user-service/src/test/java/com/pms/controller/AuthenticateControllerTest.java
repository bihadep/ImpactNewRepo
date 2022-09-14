package com.pms.controller;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;import org.springframework.security.core.GrantedAuthority;

import com.pms.model.User;
import com.pms.repository.UserRepository;
import com.pms.service.impl.AuthenticationService;
import com.pms.service.impl.UserServiceImpl;
import com.pms.util.JwtUtil;

@ExtendWith(MockitoExtension.class)
class AuthenticateControllerTest {

	@Mock
	private AuthenticationManager authManager;

	@Mock
	private UserServiceImpl userService;
	
	@Mock
	private AuthenticationService authService;
	
	@Mock
	private UserRepository userRepo;

	@Mock
	JwtUtil jwtUtil;
	
	@InjectMocks
	private AuthenticateController authenticateController;

	

	@Test
	void testAuthenticate() {
	
		
	}

	@Test
	void testLogout() {

	}

	@Test
	void testValidateToken() {

	}

	@Test
	void testChangePassword() {

	}

	@Test
	void testForgotPassword() {

	}

}
