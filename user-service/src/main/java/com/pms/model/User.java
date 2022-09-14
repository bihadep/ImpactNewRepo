package com.pms.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_tbl")
public class User {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;
	private String firstName;
	private String lastName;
	
	@Email
	private String emailId;
	
	@JsonFormat(pattern="dd/mm/yyyy")
	private String dateOfBirth;
	
	@JsonFormat(pattern="dd/mm/yyyy")
	private String dateOfJoining;
	
	private Boolean status;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Login login;
	
	private String employeeId;
	
	private String specialization;
	


}
