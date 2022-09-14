package com.pms.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.pms.dto.UpdateUser;
import com.pms.vo.UserRequestInfo;
import com.pms.dto.UserResponse;
import com.pms.model.Login;
import com.pms.model.Role;
import com.pms.model.User;

@SpringBootTest
class UserRepositoryTest {
	

	Login login , login2;	
	User user;	
	UserRequestInfo  requestInfo;
	List<Role> roleList;
	UpdateUser updateUser;

	List<UserResponse> userResponsesList;
	List<User> usersList;
	UserResponse userResponse;
	
	@Mock
	private UserRepository userRepository;
	
	@BeforeEach
	void setUp() {
		login = new Login(1L, "bihadep@gmail.com", "", "password@123", 1L, "");
		login2 = new Login(2L, "amitk@gmail.com", "", "amit@123", 1L, "");
		updateUser = new UpdateUser("DR001", false, "Password@123");
		user = new User(1L, "Mr", "Praful", "bihade", "bihadep@gmail.com", "06/05/1998", "06/03/2022", true, login, "DR001","Ortho");
		//requestInfo = new UserRequestInfo(1L, "Mr", "praful", "bihade", "bihadep@gmail.com", "06/05/1997", "06/03/2022", true, 1L, "DR001");
		userResponsesList = new ArrayList<>();
		userResponsesList.add(new UserResponse("DR001", "Praful", "Bihade", true, "05/02/2021", "Ortho"));
		userResponsesList.add(new UserResponse("DR002", "Amit", "kolhe", true, "07/06/2021", "Ortho"));

		usersList = new ArrayList<>();
		usersList.add(new User(1L, "Mr", "praful", "bihade", "bihadep@gmail.com", "06/05/1998", "06/03/2022", true, login, "DR001","Ortho"));
		usersList.add(new User(2L, "Mr", "Amit", "kolhe", "amitk@gmail.com", "06/05/1995", "07/03/2022", true, login, "DR002","Ortho"));

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
	void testFindByEmployeeId() {
		Mockito.when(userRepository.findByEmployeeId("DR001")).thenReturn(user);
		User actualUser = userRepository.findByEmployeeId("DR001");
		assertThat(actualUser.getFirstName()).isEqualTo("Praful");
	}

	@Test
	void testFindByEmailId() {
		Mockito.when(userRepository.findByEmailId("bihadep@gmail.com")).thenReturn(user);
		User actualUser = userRepository.findByEmailId("bihadep@gmail.com");
		assertThat(actualUser.getEmployeeId()).isEqualTo("DR001");
	}

	@Test
	void testFindByEmployeeIdStartWith() {
		Mockito.when(userRepository.findByEmployeeIdStartWith("DR")).thenReturn(usersList);
		List<User>  actualList = userRepository.findByEmployeeIdStartWith("DR");
		assertEquals(2,actualList.size());
		
	}

	@Test
	void testGetUsersByRoleId() {
		
		Mockito.when(userRepository.getUsersByRoleId(1L)).thenReturn(usersList);
		List<User>  actualList = userRepository.getUsersByRoleId(1L);
		
		assertEquals(actualList.size(), 2);
	}

	@Test
	void testGetUserFromToken() {
		Mockito.when(userRepository.getUserFromToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJyb2xlcyI6W3siYXV0aG9yaXR5IjoiUk9"
				+ "MRV9BZG1pbiJ9XSwiZXhwIjoxNjU3NjYyOTM4LCJpYXQiOjE2NTc2NDQ5Mzh9.BQphOE9Z3e6e1pi3qtUc3f3v0PFW59Oa6ch60HY5vkEgVyMhV0jlFyWNg4gI6ZZ"
				+ "3WHX0WV-eL9C1kuEECYai2w")).thenReturn(user);
		
		User actualUser = userRepository.getUserFromToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJyb2xlcyI6W3siYXV0aG9yaXR5I"
				+ "joiUk9MRV9BZG1pbiJ9XSwiZXhwIjoxNjU3NjYyOTM4LCJpYXQiOjE2NTc2NDQ5Mzh9.BQphOE9Z3e6e1pi3qtUc3f3v0PFW59Oa6ch60HY5vkEgVyMhV0jlFyWNg"
				+ "4gI6ZZ3WHX0WV-eL9C1kuEECYai2w");
		
		assertThat(actualUser.getEmailId()).isEqualTo("bihadep@gmail.com");
	}

	@Test
	void testGetUserCount() {
		Mockito.when(userRepository.getUserCount(1L)).thenReturn(3L);
	Long actualCount = userRepository.getUserCount(1L);
	assertEquals(3, actualCount);
	
	}

}
