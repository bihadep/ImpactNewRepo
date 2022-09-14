package com.pms.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.pms.dto.UpdateUser;
import com.pms.dto.UserCountDto;
import com.pms.dto.UserResponse;
import com.pms.exception.UserAlreadyExistWithGivenEmail;
import com.pms.exception.UserNotFoundException;
import com.pms.model.Login;
import com.pms.model.Role;
import com.pms.model.User;
import com.pms.repository.LoginRepository;
import com.pms.repository.RoleRepository;
import com.pms.repository.UserRepository;
import com.pms.service.EmailService;
import com.pms.service.UserService;
import com.pms.util.UserRequestInfoMapper;
import com.pms.util.UserResponseMapper;
import com.pms.vo.UserRequestInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private EmailService emailService;

	@Autowired
	private UserRequestInfoMapper requestInfoMapper;

	@Autowired
	private UserResponseMapper responseMapper;

	@Autowired
	private UserRepository repo;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	LoginRepository loginRepo;

	@Override
	public User saveUser(UserRequestInfo userInfo) {
		User user = requestInfoMapper.mapRequestToUser(userInfo);
		User alreadyUser = repo.findByEmailId(user.getEmailId());
		User userdb = null;
		String password = user.getLogin().getDefaultPassword() == null ? user.getLogin().getPassword()
				: user.getLogin().getDefaultPassword();
		log.info("Role =  {}", userInfo.getRoleId());
		log.info("Default password >> " + password);
		log.info("patient password >> " + password);
		if (userInfo.getRoleId() == 4) {
			user.getLogin().setDefaultPassword("1");
			user.getLogin().setPassword(passwordEncoder.encode(password));
		} else {
			user.getLogin().setDefaultPassword(passwordEncoder.encode(password));
		}
		// ObjectUtils.isEmpty(alreadyUser) ? repo.save(user):throw new
		// UserAlreadyExistWithGivenEmail();
		log.info("inside user saveUser serviceImpl");
		if (ObjectUtils.isEmpty(alreadyUser)) {
			userdb = repo.save(user);
		} else {
			throw new UserAlreadyExistWithGivenEmail(
					"User already Exits with given Email ,Please Provide another Email Id");
		}
		String mail = emailService.sendSimpleMail(user.getEmailId(), password, userdb.getFirstName());
		String empId = userdb.getEmployeeId();
		empId += String.format("%03d", userdb.getId());
		userdb.setEmployeeId(empId);

		return repo.save(userdb);
	}

	// update password,status, employeeId
	@Override
	public User updateUser(UpdateUser user) {
		User userdb = repo.findByEmployeeId(user.getEmployeeId());
		if (ObjectUtils.isEmpty(userdb)) {
			throw new UserNotFoundException("User with employeeId " + user.getEmployeeId() + " doest not exist");
		}
		log.info("inside user updateUser serviceImpl");
		if (ObjectUtils.isEmpty(user.getPassword())) {

			userdb.setStatus(user.isStatus());
		} else {
			userdb.getLogin().setPassword(user.getPassword());
		}
		return repo.save(userdb);
	}

	@Override
	public User getUser(Long UserId) {
		Optional<User> u = repo.findById(UserId);

		log.debug("inside user getUser serviceImpl" + UserId);
		return u.isPresent() ? u.get()
				: u.orElseThrow(() -> new UserNotFoundException("User not available with given Id"));
	}

	@Override
	public List<UserResponse> getAllUsers() {
		List<User> dbuserList = repo.findAll();
		log.info("inside user getAllUsers serviceImpl");
		return responseMapper.mapToUserResponse(dbuserList);
	}

	@Override
	public List<User> getAllUserWithLogin() {
		log.info("inside user getAllUserWithLogin serviceImpl");
		return repo.findAll();
	}

	@Override
	public List<UserResponse> getAllUserByRoleId(long roleId) {

		log.debug("Inside user getAllUserByRoleId serviceImpl" + roleId);
		List<User> dbuserList = repo.getUsersByRoleId(roleId);
		return responseMapper.mapToUserResponse(dbuserList);

	}

	@Override
	public UserResponse getUserByID(String employeeid) {
		User user = repo.findByEmployeeId(employeeid);
		UserResponse response = null;
		log.debug("Inside user getUserByID serviceImpl" + employeeid);
		if (ObjectUtils.isEmpty(user)) {
			throw new UserNotFoundException("Please provide employee Id in DR001 OR NR001 Format ");
		} else {
			response = responseMapper.mapToUserResponseUser(user);
		}
		return response;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByEmailId(username);
		if (!ObjectUtils.isEmpty(user)) {
			String roleName = "";
			Long roleId = user.getLogin().getRoleId();
			if (!ObjectUtils.isEmpty(roleId)) {
				Optional<Role> role = roleRepo.findById(roleId);
				if (role.isPresent()) {
					roleName = role.get().getRoleName();
				}
			}
			String password = "";

			if (user.getLogin().getRoleId() == 4) {
				password = user.getLogin().getPassword();
			} else {
				if (null == user.getLogin().getDefaultPassword()) {
					password = user.getLogin().getPassword();
				} else {
					password = user.getLogin().getDefaultPassword();
				}
			}

			return new org.springframework.security.core.userdetails.User(user.getEmailId(), password,
					Arrays.asList(new SimpleGrantedAuthority("ROLE_" + roleName)));
		} else {
			throw new UserNotFoundException("User with " + username + " does not exist");
		}
	}

	public List<Role> getAllRoles() {
		return roleRepo.findAll();
	}

	public User getUserFromToken(String jwtToken) {
		User user = repo.getUserFromToken(jwtToken);
		if (ObjectUtils.isEmpty(user)) {
			log.error("UserServiceImpl >> getUserFromToken >> Invalid jwt token, token does not exist in database");
			return null;
		}
		return user;
	}

	public UserCountDto countUser() {
		long physicianCount = repo.getUserCount(2L);
		long nurseCount = repo.getUserCount(3L);
		long patientCount = repo.getUserCount(4L);
		return new UserCountDto(physicianCount, nurseCount, patientCount);
	}

	@Override
	public User getUserByEmailId(String emailId) {
		return repo.findByEmailId(emailId);
	}

	@Override
	public List<User> getPhysicianDetails() {
		// ROLE-ID 2 IS FOR PHYSICIAN
		return repo.getUsersByRoleId(2l);
	}

	@Transactional
	public void changeDefaultPasswordToNull(String emailId) {
		loginRepo.changeDefaultPasswordToNull(emailId);
	}
}