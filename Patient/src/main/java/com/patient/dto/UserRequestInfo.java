package com.patient.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestInfo {
	
	
	private Long id;
	
	@NotBlank(message = "“Kindly select the title")
	private String title;
	
	@NotBlank(message = "First name cannot be empty")
	@Min(value = 2,message = "Please don’t use abbreviations")
	private String firstName;
	
	@NotBlank(message = "Last name cannot be empty")
	@Min(value = 2,message = "Please don’t use abbreviations")
	private String lastName;
	
	
	@NotBlank(message = "Please enter your email address e.g. exampleusername@xyzdomain,com")
	//@Email(message = "invalid format" )
	private String emailId;
	
	@JsonFormat(pattern="dd/mm/yyyy")
	@NotBlank(message = "Please enter a valid Date of birth")
	private String dateOfBirth;

	//Please enter a valid date of birth -- if date is future date
	//@Future(message = "Please enter a valid date of birth ")

	
	@JsonFormat(pattern="dd/mm/yyyy")
	//@NotBlank(message = "Please enter a valid Date of Joining")
	private String dateOfJoining;
	
	@NotBlank(message = "status can't be blank")
	private boolean status;
	
	@NotBlank(message = "Please select a valid role")
	//@Digits(integer = 1, fraction = 0)
	private Long roleId;
	private String password;
	
	private String employeeId;
	
}