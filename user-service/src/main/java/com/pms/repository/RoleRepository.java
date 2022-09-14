package com.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
