package com.patient.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.entity.Patient;
import com.patient.entity.PatientProcedure;
import com.patient.exceptio.ResourceNotFoundException;
import com.patient.repository.PatientRepository;
import com.patient.service.PatientProcedureService;
import com.patient.util.DTOConverter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PatientProcedureServiceImpl implements PatientProcedureService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public Patient savePatientProcedureDetails(List<PatientProcedure> patientProcedure, Long patientId)
			throws ResourceNotFoundException {
		log.debug("Starting.. --Data Received -> ", patientProcedure + " -- " + patientId);
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient", "PatientId", patientId));
		patient.setPatientProcedure(patientProcedure);
		patient = patientRepository.save(patient);
		log.debug("Ending.. --Response Data -> ", patient);
		return patient;
	}

	@Override
	public List<PatientProcedure> getPatientProcedureDetailsByPatientId(Long patientId) throws ResourceNotFoundException {
		log.debug("Starting.. --Data Received -> ", patientId);
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient", "PatientId", patientId));
		List<PatientProcedure> listOfPatientProcedure = patient.getPatientProcedure();
		log.debug("Ending.. --Response Data -> ", listOfPatientProcedure);
		return listOfPatientProcedure;
	}

	@Override
	public Patient updatePatientProcedureDetailsByPatientId(PatientProcedure patientProcedure, Long patientId)
			throws ResourceNotFoundException {
		log.debug("Starting.. --Data Received -> ", patientProcedure + " -- " + patientId);
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient", "PatientId", patientId));
		patient = DTOConverter.updatePatientProcedureConversion(patient, patientProcedure);
		patient = patientRepository.save(patient);
		log.debug("Ending.. --Response Data -> ", patient);
		return patient;
	}

}
