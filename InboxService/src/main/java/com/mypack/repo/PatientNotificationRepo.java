package com.mypack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mypack.entity.PatientNotification;

public interface PatientNotificationRepo extends JpaRepository<PatientNotification, Long>{
	
	List<PatientNotification> findByPatientIdAndIsRead(Long patientId, boolean isRead);
	
	@Query("select count (n) from PatientNotification n where n.patientId= ?1 and n.isRead = false")
	long getNotificationCount(Long id);
}
		