package com.patient.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.patient.entity.PatientVitalDetails;

@Repository
public interface PatientVitalDetailsRepository extends JpaRepository<PatientVitalDetails, Long>{
	
	@Query(value = "select * from patient_vital_details where patient_id=:id ", nativeQuery = true)
	public Optional<PatientVitalDetails> findByPatientId(@Param(value = "id") Long id);
	
}
