package com.patient.service;

import java.util.List;

import com.patient.entity.Patient;
import com.patient.entity.PatientDiagnosticDetails;
import com.patient.exceptio.ResourceNotFoundException;

public interface PatientDiagnosticService {

	public Patient savePatientDiagnosticDetails(List<PatientDiagnosticDetails> patientDiagnosticDetails,
			Long patientId) throws ResourceNotFoundException;

	public List<PatientDiagnosticDetails> getAllPatientDiagnosticDetailsByPatientId(Long patientId)
			throws ResourceNotFoundException;
	
	
	//Thinking about get All Diagnostic details of patient's last Visit by Date
//	public List<PatientDiagnosticDetails> getPatientDiagnosticDetailsByPatientId(Long patientId)
//			throws ResourceNotFoundException;

	public Patient updatePatientDiagnosticDetailsByPatientId(PatientDiagnosticDetails patientDiagnosticDetails,Long patientId)
			throws ResourceNotFoundException;
}
