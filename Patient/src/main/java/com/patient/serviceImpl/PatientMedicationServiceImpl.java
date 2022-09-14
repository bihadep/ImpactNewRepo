package com.patient.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.entity.Patient;
import com.patient.entity.PatientMedication;
import com.patient.exceptio.ResourceNotFoundException;
import com.patient.repository.PatientRepository;
import com.patient.service.PatientMedicationService;
import com.patient.util.DTOConverter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PatientMedicationServiceImpl implements PatientMedicationService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public List<PatientMedication> savePatientMedicationDetails(List<PatientMedication> patientMedication,
			Long patientId) throws ResourceNotFoundException {
		log.debug("Starting.. --Data Received -> ", patientMedication + " -- " + patientId);
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient", "patientId", patientId));
		patient.setPatientMedication(patientMedication);
		patient = patientRepository.save(patient);
		List<PatientMedication> listOfPatientMedication = patient.getPatientMedication();
		log.debug("Ending.. --Response Data -> ", listOfPatientMedication);
		return listOfPatientMedication;
	}

	@Override
	public List<PatientMedication> getPatientMedicationDetails(Long patientId) throws ResourceNotFoundException {
		log.debug("Starting.. --Data->", patientId);
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient", "patientId", patientId));
		List<PatientMedication> listOfPatientMedicationData = patient.getPatientMedication();
		log.debug("Ending.. --Response Data -> ", listOfPatientMedicationData);
		return listOfPatientMedicationData;
	}

	@Override
	public Patient updatePatientMedicationDetails(PatientMedication patientMedication, Long patientId)
			throws ResourceNotFoundException {
		log.debug("Starting.. --Data Received -> ", patientMedication + " -- " + patientId);
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient", "patientId", patientId));
		patient = DTOConverter.updatingPatientMedicationDetails(patientMedication, patient);
		patient = patientRepository.save(patient);
		log.debug("Ending.. --Response Data -> ", patient);
		return patient;

	}

}
