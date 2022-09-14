package com.patient.service;

import java.util.List;

import com.patient.dto.PatientDataUpdateDTO;
import com.patient.dto.PatientExtraDataDTO;
import com.patient.dto.PatientSignupDTO;
import com.patient.entity.Patient;
import com.patient.exceptio.ResourceNotFoundException;

public interface PatientService {

	public Patient savePatient(PatientSignupDTO patientSignupDTO);
	public List<Patient> getAllPatient();
	public Patient getPatientById(Long id) throws ResourceNotFoundException;
	public Patient getPatientByName(String name);
	public PatientSignupDTO getPatinetByEmailId(String emailId) throws ResourceNotFoundException;
	public void savePatientsExtraData(PatientExtraDataDTO patientExtraDataDTO, String patientEmailId) throws ResourceNotFoundException;
	public Patient updatePatientData(PatientDataUpdateDTO patientDataUpdateDTO, Long patientId) throws ResourceNotFoundException;
}
