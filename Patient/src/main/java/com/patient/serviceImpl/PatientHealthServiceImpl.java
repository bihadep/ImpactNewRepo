package com.patient.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.dto.PatientVitalDetailsDTO;
import com.patient.entity.Patient;
import com.patient.entity.PatientVitalDetails;
import com.patient.exceptio.ResourceNotFoundException;
import com.patient.repository.PatientRepository;
import com.patient.repository.PatientVitalDetailsRepository;
import com.patient.service.PatientHealthService;
import com.patient.util.DTOConverter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PatientHealthServiceImpl implements PatientHealthService {
	
	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private PatientVitalDetailsRepository patientVitalDetailsRepository;

	@Override
	public void savePatientVitalDetails(PatientVitalDetails patientVitalDetails, Long patientId)
			throws ResourceNotFoundException {
		log.debug("Starting.. --Data Received -> ", patientVitalDetails + " -- " + patientId);
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient", "PatientId", patientId));
		patientVitalDetails.setPatient(patient);
		patientVitalDetailsRepository.save(patientVitalDetails);
	}

	@Override
	public PatientVitalDetailsDTO getPatientVitalDetailsById(String patientEmailId) throws ResourceNotFoundException {
		log.debug("Starting.. --Data Received -> ",  patientEmailId);
		Patient patient = patientRepository.findByEmailId(patientEmailId).get();
			PatientVitalDetails patientVitalDetails = patientVitalDetailsRepository
					.findByPatientId(patient.getPatientId())
					.orElseThrow(() -> new ResourceNotFoundException("PatientVitalDetails", "PatientId", patient.getPatientId()));
			PatientVitalDetailsDTO patientVitalDetailsDTO = DTOConverter.patientVitalDetailsToPatientVitalDetailsDTO(patientVitalDetails);	
		log.debug("Ending.. --Response Data -> ", patientVitalDetailsDTO);	
		return patientVitalDetailsDTO;
	}
	
	public PatientVitalDetailsDTO getPatientVitalDetailsById(Long patientId) throws ResourceNotFoundException {
		log.debug("Starting.. --Data Received -> ",  patientId);
			PatientVitalDetails patientVitalDetails = patientVitalDetailsRepository
					.findByPatientId(patientId)
					.orElseThrow(() -> new ResourceNotFoundException("PatientVitalDetails", "PatientId", patientId));
			PatientVitalDetailsDTO patientVitalDetailsDTO = DTOConverter.patientVitalDetailsToPatientVitalDetailsDTO(patientVitalDetails);	
		log.debug("Ending.. --Response Data -> ", patientVitalDetailsDTO);	
		return patientVitalDetailsDTO;
	}

	@Override
	public PatientVitalDetailsDTO updatePatientVitalDetails(PatientVitalDetailsDTO patientVitalDetailsDTO, Long patientId)
			throws ResourceNotFoundException {
		log.debug("Starting.. --Data Received -> ", patientVitalDetailsDTO + " -- " + patientId);
		if (patientRepository.existsById(patientId)) {
			PatientVitalDetails patientVitalDetails = patientVitalDetailsRepository
					.findByPatientId(patientId)
					.orElseThrow(() -> new ResourceNotFoundException("PatientVitalDetails", "PatientId", patientId));
			patientVitalDetails = DTOConverter.patientVitalDetailsDTOToPatientVitalDetails(patientVitalDetails,
					patientVitalDetailsDTO);
			patientVitalDetails= patientVitalDetailsRepository.save(patientVitalDetails);
			PatientVitalDetailsDTO patientVitalDetailsDTO2 = DTOConverter.patientVitalDetailsToPatientVitalDetailsDTO(patientVitalDetails);
			log.debug("Ending.. --Response Data -> ", patientVitalDetailsDTO2);
			return patientVitalDetailsDTO2;
		}else {
			throw new ResourceNotFoundException("PatientVitalDetails", "PatientId", patientId);
		}
		

	}

}
