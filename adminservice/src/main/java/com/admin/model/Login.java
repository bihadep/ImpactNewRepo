package com.admin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {


	private Long loginId;
	
	private String userName;
	private String password;
	
	
	private String defaultPassword;
	
	private Long roleId;
	
	private String token; 

	
	
	
}