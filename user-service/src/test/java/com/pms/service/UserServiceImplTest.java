package com.pms.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pms.dto.UpdateUser;
import com.pms.vo.UserRequestInfo;
import com.pms.dto.UserResponse;
import com.pms.model.Login;
import com.pms.model.Role;
import com.pms.model.User;
import com.pms.repository.RoleRepository;
import com.pms.repository.UserRepository;
import com.pms.service.impl.UserServiceImpl;
import com.pms.util.PasswordGeneratorUtil;
import com.pms.util.UserRequestInfoMapper;
import com.pms.util.UserResponseMapper;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserServiceImplTest {

	Login login , login2;	
	User user;	
	UserRequestInfo  requestInfo;
	List<Role> roleList;
	UpdateUser updateUser;

	List<UserResponse> userResponsesList;
	List<User> usersList;
	UserResponse userResponse;

	@Mock
	private EmailService emailService;

	@Mock
	private PasswordGeneratorUtil passwordGeneratorUtil;

	@Mock
	private UserRequestInfoMapper requestInfoMapper;

	@Mock
	private UserResponseMapper responseMapper;

	@Mock
	private UserRepository userRepository;

	@Mock
	private RoleRepository roleRepo;

	@Mock
	PasswordEncoder passwordEncoder;

	@InjectMocks
	private UserServiceImpl  userServiceImpl;

	@BeforeEach
	void setUp() {
		login = new Login(1L, "bihadep@gmail.com", "", "password@123", 1L, "");
		login2 = new Login(2L, "amitk@gmail.com", "", "amit@123", 1L, "");
		updateUser = new UpdateUser("DR001", false, "Password@123");
		user = new User(1L, "Mr", "Praful", "bihade", "bihadep@gmail.com", "06/05/1998", "06/03/2022", true ,login, "DR001","Ortho");
		requestInfo = new UserRequestInfo(1L, "Mr", "Praful", "BIhade", "bihadep@gmail.com", "02/05/2002", "06/02/1992", true,  1L,"pasword@123", "DR001","ORTHO");
		userResponsesList = new ArrayList<>();
		userResponsesList.add(new UserResponse("DR001", "Praful", "Bihade", true, "05/02/2021", "Ortho"));
		userResponsesList.add(new UserResponse("DR002", "Amit", "kolhe", true, "07/06/2021", "Ortho"));

		usersList = new ArrayList<>();
		usersList.add(new User(1L, "Mr", "praful", "bihade", "bihadep@gmail.com", "06/05/1998", "06/03/2022", true,login , "DR001","Ortho"));
		usersList.add(new User(2L, "Mr", "Amit", "kolhe", "amitk@gmail.com", "06/05/1995", "07/03/2022", true,login, "DR002","Ortho"));

		userResponse = new UserResponse("DR001", "Praful", "Bihade", true, "05/02/2021", "Ortho");
		Role r1 = new Role(1L, "Admin");
		Role r2 = new Role(2L, "Physician");
		Role r3 = new Role(3L, "Nurse");
		Role r4 = new Role(4L, "Patient");
		
		roleList = new ArrayList<>();
		roleList.add(r1);
		roleList.add(r2);
		roleList.add(r3);
		roleList.add(r4);
		
		
	}

	@Test
	void testSaveUser() {
		Mockito.when(requestInfoMapper.mapRequestToUser(requestInfo)).thenReturn(user);
		Mockito.when(userRepository.findByEmailId("bihadep@gmail.com")).thenReturn(null);
		Mockito.when(emailService.sendSimpleMail("bihadep@gmail.com", "password", "praful")).thenReturn("mail send ");
		Mockito.when(userRepository.save(user)).thenReturn(user);

		assertEquals(user, userServiceImpl.saveUser(requestInfo));
		assertEquals(user.getFirstName(), userServiceImpl.saveUser(requestInfo).getFirstName());
	}


	@Test
	void testGetUser() {
		Optional<User> optional = Optional.of(user);
		Mockito.when(userRepository.findById(1L)).thenReturn(optional);
		assertEquals(optional.get(), userServiceImpl.getUser(1L));
	}

	@Test
	void testUpdateUser() {
		Mockito.when(userRepository.findByEmployeeId(updateUser.getEmployeeId())).thenReturn(user);
		Mockito.when(userRepository.save(user)).thenReturn(user);
		assertEquals(true, userServiceImpl.updateUser(updateUser).getStatus());
	}



	@Test
	void testGetAllUsers() {
		Mockito.when(userRepository.findAll()).thenReturn(usersList);
		Mockito.when(responseMapper.mapToUserResponse(usersList)).thenReturn(userResponsesList);
		assertEquals(2, userServiceImpl.getAllUsers().size());
	}


	@Test
	void testGetAllUserByRoleId() {
		Mockito.when(userRepository.getUsersByRoleId(1L)).thenReturn(usersList);
		Mockito.when(responseMapper.mapToUserResponse(usersList)).thenReturn(userResponsesList);
		//assertEquals(2, userServiceImpl.getAllUserByRoleId(1L).size());
		
		assertThat(userServiceImpl.getAllUserByRoleId(1L).get(0).getEmployeeId()).isEqualTo("DR001");
	}

	@Test
	void testGetUserByID() {
		Mockito.when(userRepository.findByEmployeeId("DR001")).thenReturn(user);
		Mockito.when(responseMapper.mapToUserResponseUser(user)).thenReturn(userResponse);
		assertEquals(user.getFirstName(), userServiceImpl.getUserByID("DR001").getFirstName());
	}

	@Test
	void testGetAllRoles() {
		Mockito.when(roleRepo.findAll()).thenReturn(roleList);
		
		assertEquals(4, userServiceImpl.getAllRoles().size());
	}

	@Test
	void testGetUserFromToken() {
		Mockito.when(userRepository.getUserFromToken("")).thenReturn(user);
		User actualUser  = userServiceImpl.getUserFromToken("");
		assertEquals(user.getEmployeeId(), actualUser.getEmployeeId());
	}

}
