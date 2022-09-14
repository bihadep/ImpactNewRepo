package com.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "login_tbl")
public class Login {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loginId;
	
	private String username;
	
	@Column(length = 500)
	private String password;
	
	@Column(length = 500)
	private String defaultPassword;
	
	private Long roleId;
	
	@Column(length = 500)
	private String token; 

	
	
	
}