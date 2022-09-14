package com.mypack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mypack.entity.ScheduleTimeslot;

@Repository
public interface ScheduleTimeslotRepo extends JpaRepository<ScheduleTimeslot, Long>{

	@Query("select timeslot from ScheduleTimeslot timeslot join PhysicianSchedule schedule on timeslot.scheduleId = "
			+ "schedule.id where timeslot.status = 'AVAILABLE' and schedule.employeeId = ?1")
	List<ScheduleTimeslot> getAllAvailableAppointment(String employeeId);
	
}
