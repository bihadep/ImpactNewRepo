package com.mypack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.mypack.entity.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment, Long>{

	@Query("select a from Appointment a where a.status = ?1 and a.doctorId = ?2")
	public List<Appointment> getAllAppointmentRequestForPhysician(String status, String doctorId);
	
	@Query("select a from Appointment a where a.status = ?1 and  a.patientId = ?2")
	public List<Appointment> getAllPatientAppointment(String status, String patientId);
	
	List<Appointment> findByDoctorId(String doctorId);
	
	List<Appointment> findByPatientId(String patientId);
	
	@Modifying
	@Query("update Appointment a set a.status = ?1 where a.id = ?2")
	public void changeStatus(String status, Long id);
	
}
