package com.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pms.model.Login;


@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{
	
	@Modifying
	@Query("update Login l set l.token = null where token=?1")
	void deleteToken(String token);
	
	Login findByDefaultPasswordAndUsername(String defaultPassword, String username);
	
	Login findByUsername(String username);
	
	@Modifying
	@Query("update Login l set l.password = ?1, l.defaultPassword = null where l.username = ?2")
	void changeDefaultPassword(String changePassword, String username);

	
	@Modifying
	@Query("update Login l set l.defaultPassword = null where l.username = ?1")
	void changeDefaultPasswordToNull(String username);
}
