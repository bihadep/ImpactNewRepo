package com.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.entity.PatientDiagnosticDetails;

public interface PatientDiagnosticRepository extends JpaRepository<PatientDiagnosticDetails, Long> {

}
