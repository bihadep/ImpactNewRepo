package com.mypack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mypack.entity.DoctorNotification;

@Repository
public interface DoctorNotificationRepo extends JpaRepository<DoctorNotification, Long>{

	List<DoctorNotification> findByDoctorIdAndIsAcceptAndReasonForRejectIsNull(Long userId, boolean isAccept);

	@Query("select count (n) from DoctorNotification n where n.doctorId= ?1 and n.isAccept = false and n.reasonForReject = null")
	long getNotificationCount(Long id);
}
