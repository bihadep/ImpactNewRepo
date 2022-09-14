package com.patient.service;

import java.util.List;

import com.patient.entity.Patient;
import com.patient.entity.PatientProcedure;
import com.patient.exceptio.ResourceNotFoundException;

public interface PatientProcedureService {

	public Patient savePatientProcedureDetails(List<PatientProcedure> patientProcedure,Long patientId) throws ResourceNotFoundException;
	public List<PatientProcedure> getPatientProcedureDetailsByPatientId(Long patientId) throws ResourceNotFoundException;
	public Patient updatePatientProcedureDetailsByPatientId(PatientProcedure patientProcedure,Long patientId) throws ResourceNotFoundException;
}