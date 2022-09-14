package com.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patient.entity.PatientMedication;

@Repository
public interface PatientMedicationRepository extends JpaRepository<PatientMedication, Long> {

}
