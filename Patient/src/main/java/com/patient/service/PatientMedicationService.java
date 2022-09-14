package com.patient.service;

import java.util.List;

import com.patient.entity.Patient;
import com.patient.entity.PatientMedication;
import com.patient.exceptio.ResourceNotFoundException;

public interface PatientMedicationService {

	public List<PatientMedication> savePatientMedicationDetails(List<PatientMedication> patientMedication,
			Long patientId) throws ResourceNotFoundException;

	public List<PatientMedication> getPatientMedicationDetails(Long patientId) throws ResourceNotFoundException;

	public Patient updatePatientMedicationDetails(PatientMedication patientMedication, Long patientId)
			throws ResourceNotFoundException;
}
