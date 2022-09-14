package com.patient.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patient.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	public Optional<Patient> findByfirstName(String name);
	public Optional<Patient> findByEmailId(String emailId);
}
