package com.pms.service.impl;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.pms.dto.ChangePasswordDto;
import com.pms.exception.UserNotFoundException;
import com.pms.model.Login;
import com.pms.model.User;
import com.pms.repository.LoginRepository;
import com.pms.repository.UserRepository;
import com.pms.service.EmailService;
import com.pms.util.JwtUtil;
import com.pms.util.PasswordGeneratorUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthenticationService {

	@Autowired
	LoginRepository loginRepo;
	
	@Autowired
	PasswordGeneratorUtil passwordGenerate;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	HttpServletResponse response;
	
	public void saveToken(String username, String token) {
		Login login = loginRepo.findByUsername(username);
		if(!ObjectUtils.isEmpty(login)) {
			login.setToken(token);
			loginRepo.save(login);
		}
		log.info("LoginService >> saveToken method token saved successfully");
	}
	
	@Transactional
	public void deleteToken(String token) {
		log.info("LoginService >> deleteToken method ");
		loginRepo.deleteToken(token);
	}
	
	@Transactional
	public void changePassword(ChangePasswordDto dto) throws Exception {
		String username = jwtUtil.getUsernameFromToken(response.getHeader("token"));
		String encodeDefaultPassword = loginRepo.findByUsername(username).getDefaultPassword();
		boolean isMatch = passwordEncoder.matches(dto.getDefaultPassword(), encodeDefaultPassword);
		if(!isMatch) {
			throw new Exception("Invalid Default Password");
		}
		loginRepo.changeDefaultPassword(passwordEncoder.encode(dto.getChangePassword()), username);
	}
	
	public void forgotPassword(String username) {
		User user = userRepo.findByEmailId(username);
		Login login = user.getLogin();
		if(ObjectUtils.isEmpty(user)) {
			throw new UserNotFoundException("User not found");
		}
		String defaultPassword = passwordGenerate.generateDefaultPassword();
		log.info("AuthenticationService >> forgotPassword >> username " + username + " default password " + defaultPassword);
		login.setDefaultPassword(passwordEncoder.encode(defaultPassword));
		login.setPassword(null);
		login.setToken(null);
		loginRepo.save(login);
		emailService.sendSimpleMail(username, defaultPassword, user.getFirstName());
		
	}
}
