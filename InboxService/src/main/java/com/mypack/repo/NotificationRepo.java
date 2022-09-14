package com.mypack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mypack.entity.Notification;

@Repository
public interface NotificationRepo extends JpaRepository<Notification, Long>{

	List<Notification> findByDoctorIdAndIsAcceptAndReasonForRejectIsNull(Long doctorId, boolean isAccept);
	List<Notification> findByNurseIdAndIsAcceptAndReasonForRejectIsNull(Long nurseId, boolean isAccept);
	List<Notification> findByPatientIdAndIsAcceptAndReasonForRejectIsNull(Long patientId, boolean isAccept);
	
	@Query("select count(n) from Notification n where n.doctorId = ?1 and n.isAccept = false and n.reasonForReject = null")
	long getUnreadNotificationForDoctor(Long doctorId);  
	
	@Query("select count(n) from Notification n where n.nurseId = ?1 and n.isAccept = false  and n.reasonForReject = null")
	long getUnreadNotificationForNurse(Long nurseId);  
	
	@Query("select count(n) from Notification n where n.patientId = ?1 and n.isAccept = false  and n.reasonForReject = null")
	long getUnreadNotificationForPatient(Long patientId);  
}
