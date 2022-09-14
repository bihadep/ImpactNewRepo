package com.patient.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import com.patient.dto.EmailPropertyDto;
import com.patient.dto.PatientDataUpdateDTO;
import com.patient.dto.PatientExtraDataDTO;
import com.patient.dto.PatientSignupDTO;
import com.patient.dto.SuccessResponse;
import com.patient.dto.UserRequestInfo;
import com.patient.entity.Patient;
import com.patient.exceptio.ResourceNotFoundException;
import com.patient.repository.PatientRepository;
import com.patient.service.PatientService;
import com.patient.util.DTOConverter;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	final String USER_SERVICE_URL = "http://IAM-SERVICE/user";

	@Override
	public Patient savePatient(PatientSignupDTO patientSignupDTO){
		log.debug("Starting.. --Data Received -> ", patientSignupDTO );
		Patient patient = patientRepository.save(DTOConverter.PatientSignupDTOToPatient(patientSignupDTO));
		
		//Calling User-Service
		UserRequestInfo request = new UserRequestInfo();
		request.setTitle(patient.getTitle());
		request.setFirstName(patient.getFirstName());
		request.setLastName(patient.getLastName());
		request.setDateOfBirth(patient.getDateOfBirth());
		request.setEmailId(patient.getEmailId());
		request.setPassword(patient.getPassword());
		request.setRoleId(4L);
		request.setStatus(true);
		
		SuccessResponse userServiceRespone = restTemplate.postForObject(USER_SERVICE_URL + "/savePatient", request, SuccessResponse.class);
		if(userServiceRespone.getHttpStatus() == HttpStatus.OK) {
			log.info("Response from user service ->> {}",userServiceRespone);
		}
		
		log.debug("Ending.. --Response Data -> ", patient);
		return patient;
	}

	@Override
	public List<Patient> getAllPatient(){
		List<Patient> listOfPatient = patientRepository.findAll();
		log.debug("Ending.. --Response Data -> ", listOfPatient);
		return listOfPatient;
	}
	
	@Override
	public Patient getPatientById(Long id) throws ResourceNotFoundException{
		log.debug("Starting.. --Data Received -> ", id );
		Patient patient = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient","patientId",id));
		log.debug("Ending.. --Response Data -> ", patient);
		return patient;
	}

	@Override
	public Patient getPatientByName(String name) {
		log.debug("Starting.. --Data Received -> ", name );
		Patient patient = patientRepository.findByfirstName(name).get();
		log.debug("Ending.. --Response Data -> ", patient);
		return patient;
	}

	@Override
	public PatientSignupDTO getPatinetByEmailId(String emailId) throws ResourceNotFoundException {
		log.debug("Starting.. --Data Received -> ", emailId );
	Patient patinet	= patientRepository.findByEmailId(emailId)
				.orElseThrow(()-> new ResourceNotFoundException("Patient", "emailId", emailId));
		PatientSignupDTO patientSignupDTO = DTOConverter.PatientTOPatientSignupDTO(patinet);
		log.debug("Ending.. --Response Data -> ", patientSignupDTO);
		return patientSignupDTO;	
	}

	@Override
	public void savePatientsExtraData(PatientExtraDataDTO patientExtraDataDTO, String patientEmailId) throws ResourceNotFoundException {
		log.debug("Starting.. --Data Received -> ", patientExtraDataDTO + " -- " + patientEmailId);
		Patient patient = patientRepository.findByEmailId(patientEmailId)
							.orElseThrow(()-> new ResourceNotFoundException("Patient", "patientEmailId",patientEmailId ));
		patient = DTOConverter.patientExtraDataDTOToPatient(patientExtraDataDTO,patient);
		patient = patientRepository.save(patient);
		
		//restTemplate.put(USER_SERVICE_URL + "updateDefaultPasswordToNull/"+patientEmailId, null);
		 HttpEntity<EmailPropertyDto> requestEntity = new HttpEntity<EmailPropertyDto>(new EmailPropertyDto(patientEmailId));
		 ResponseEntity<SuccessResponse> response = restTemplate.exchange(USER_SERVICE_URL + "/updateDefaultPasswordToNull", 
				HttpMethod.PUT, requestEntity, SuccessResponse.class);
		 if(!ObjectUtils.isEmpty(response)) {
			 log.info("savePatientsExtraData >> {}", response.getBody().getHttpStatus());
		 }
		log.debug("Ending.. --Response Data -> ", patient);	
	}

	@Override
	public Patient updatePatientData(PatientDataUpdateDTO patientDataUpdateDTO, Long patientId) throws ResourceNotFoundException {
		log.debug("Starting.. --Data Received -> ", patientDataUpdateDTO + " -- " + patientId);
		Patient patient = patientRepository.findById(patientId)
								.orElseThrow(()-> new ResourceNotFoundException("Patient", "patientId",patientId ));
		Patient patientAfterUpdate = patientRepository.save(DTOConverter.PatientDataUpdateDTOToPatient(patientDataUpdateDTO,patient));
		log.debug("Ending.. --Response Data -> ", patientAfterUpdate);
		return patientAfterUpdate;
	}

}
