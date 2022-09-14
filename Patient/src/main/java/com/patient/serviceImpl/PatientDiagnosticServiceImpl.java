package com.patient.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.entity.Patient;
import com.patient.entity.PatientDiagnosticDetails;
import com.patient.exceptio.ResourceNotFoundException;
import com.patient.repository.PatientRepository;
import com.patient.service.PatientDiagnosticService;
import com.patient.util.DTOConverter;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class PatientDiagnosticServiceImpl implements PatientDiagnosticService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public Patient savePatientDiagnosticDetails(List<PatientDiagnosticDetails> patientDiagnosticDetails,Long patientId) throws ResourceNotFoundException {
		log.debug("Starting.. --Data Received -> ", patientDiagnosticDetails + " -- " + patientId);
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(()-> new ResourceNotFoundException("Patient", "PatientId", patientId));
		patient.setPatientDiagnosticDetails(patientDiagnosticDetails);
		log.debug("Ending.. --Response Data -> ", patient);
		return patientRepository.save(patient);
	}

	@Override
	public List<PatientDiagnosticDetails> getAllPatientDiagnosticDetailsByPatientId(Long patientId) throws ResourceNotFoundException {
		log.debug("Starting.. --Data Received -> ", patientId);
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(()-> new ResourceNotFoundException("Patient", "PatientId", patientId));
		List<PatientDiagnosticDetails> listOfPatientDiagnosticDetails =  patient.getPatientDiagnosticDetails(); 
		log.debug("Ending.. --Response Data -> ", listOfPatientDiagnosticDetails);
		return listOfPatientDiagnosticDetails;
	}

	@Override
	public Patient updatePatientDiagnosticDetailsByPatientId(PatientDiagnosticDetails patientDiagnosticDetails,Long patientId) throws ResourceNotFoundException {
		log.debug("Starting.. --Data Received -> ", patientDiagnosticDetails + " -- " + patientId);
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(()-> new ResourceNotFoundException("Patient", "PatientId", patientId));

		patient = DTOConverter.updatePatientDiagnosticDetails(patientDiagnosticDetails,patient);
		patient = patientRepository.save(patient);
		log.debug("Ending.. --Response Data -> ", patient);
		return patient;
		
	}

}
