package com.patient.service;

import com.patient.dto.PatientVitalDetailsDTO;
import com.patient.entity.PatientVitalDetails;
import com.patient.exceptio.ResourceNotFoundException;

public interface PatientHealthService {

	public void savePatientVitalDetails(PatientVitalDetails patientVitalDetails, Long patientId) throws ResourceNotFoundException;
	public PatientVitalDetailsDTO getPatientVitalDetailsById(String patientEmailId) throws ResourceNotFoundException;
	public PatientVitalDetailsDTO updatePatientVitalDetails(PatientVitalDetailsDTO patientVitalDetails, Long patientId) throws ResourceNotFoundException;
	
	
}
