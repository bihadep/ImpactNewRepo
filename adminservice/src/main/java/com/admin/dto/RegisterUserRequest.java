package com.admin.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest {

	private Long id;

	@NotBlank(message = "“Kindly select the title")
	private String title;

	@NotBlank(message = "First name cannot be empty")
	@Min(value = 2, message = "Please don’t use abbreviations")
	private String firstName;

	@NotBlank(message = "Last name cannot be empty")
	@Min(value = 2, message = "Please don’t use abbreviations")
	private String lastName;

	@NotBlank(message = "Please enter your email address e.g. example@xyzdomain.com")
	private String emailId;

	@JsonFormat(pattern = "dd/mm/yyyy")
	@NotBlank(message = "Please enter a valid Date of birth")
	private String dateOfBirth;

	private String dateOfJoining;

	@NotBlank(message = "status can't be blank")
	private boolean status;

	@NotBlank(message = "Please select a valid role")
	private Long roleId;

	private String employeeId;
	private String specialization;
}
