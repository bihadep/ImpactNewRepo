package com.pms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pms.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
		
	
	User findByEmployeeId(String EmployeeId);
	
	User findByEmailId(String emailId);
	
	@Query (value =
			"SELECT * FROM user_tbl WHERE employee_id Like :empId%",
			nativeQuery=true)
	List<User> findByEmployeeIdStartWith(@Param("empId")  String empId);
	
	
	//@Query("From User where employeeId Like 'NR%' ")
	//List<User> findByEmployeeIdStartWith(String empId);
	
	@Query("select u from User u join Login l on l.loginId = u.login.loginId where l.roleId = ?1")
	public List<User> getUsersByRoleId(Long roleId);
	
	@Query("select u from User u where u.login.token = ?1")
	public User getUserFromToken(String token);
	
	@Query("select count(u) from User u where u.login.roleId = ?1")
	public long getUserCount(Long roleId);
	
	@Query("select distinct u.specialization FROM User u")
	List<String> findDistinctSpecialization();
	
}
