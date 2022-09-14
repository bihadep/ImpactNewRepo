package com.pms.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.pms.model.Login;
import com.pms.model.User;
import com.pms.vo.UserRequestInfo;

@Component
public class UserRequestInfoMapper {

	@Autowired
	private PasswordGeneratorUtil passwordGeneratorUtil;

	public User mapRequestToUser(UserRequestInfo requestInfo) {

		Login login = new Login();
		login.setUsername(requestInfo.getEmailId());
		if (requestInfo.getRoleId() == 4) {
			login.setPassword(requestInfo.getPassword());
		} else {
			login.setDefaultPassword(passwordGeneratorUtil.generateDefaultPassword());
		}
		login.setRoleId(requestInfo.getRoleId());

		User user = new User();
		user.setFirstName(requestInfo.getFirstName());
		user.setLastName(requestInfo.getLastName());
		user.setSpecialization(requestInfo.getSpecialization());
		user.setStatus(requestInfo.isStatus());
		user.setDateOfBirth(requestInfo.getDateOfBirth());

		String dateInString = new SimpleDateFormat(Constants.datePattern).format(new Date());

		user.setDateOfJoining(dateInString);

		user.setEmailId(requestInfo.getEmailId());
		user.setTitle(requestInfo.getTitle());

		user.setLogin(login);
		String empId = "";
		if (requestInfo.getRoleId() == 2) {
			empId = Constants.phyEmpId;
		}
		if (requestInfo.getRoleId() == 3) {
			empId = Constants.NurseEmpId;
		}
		if (requestInfo.getRoleId() == 4) {
			empId = Constants.PatientEmpId;
		}

		user.setEmployeeId(empId);

		return user;

	}
}
