package com.mypack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypack.entity.PhysicianSchedule;

@Repository
public interface PhysicianScheduleRepo extends JpaRepository<PhysicianSchedule, Long>{

	List<PhysicianSchedule> findByEmployeeId(String employeeId);
}
