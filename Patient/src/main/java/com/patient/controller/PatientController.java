package com.patient.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient.dto.PatientDataUpdateDTO;
import com.patient.dto.PatientExtraDataDTO;
import com.patient.dto.PatientSignupDTO;
import com.patient.entity.Patient;
import com.patient.exceptio.ResourceNotFoundException;
import com.patient.exceptio.ResponseMessage;
import com.patient.service.PatientService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping(value ="patient")
public class PatientController {
	
	@Autowired
	private PatientService patientServiceImpl;

	@PostMapping("/saveSignupData")
	public ResponseEntity<ResponseMessage> savePatientSignupDetails(@RequestBody PatientSignupDTO patientSignupDTO){
		log.debug("Starting.. --Data Received -> ", patientSignupDTO );
		patientServiceImpl.savePatient(patientSignupDTO);
		ResponseMessage responseMessage = new ResponseMessage("Data saved successfully  ", "Patient's Signup data", new Date().toString());
		return new ResponseEntity<ResponseMessage>(responseMessage,HttpStatus.OK);
	}
	
	@PutMapping("/saveDetailedData/{patientEmailId}")
	public ResponseEntity<ResponseMessage> savePatientDetailedData(@RequestBody PatientExtraDataDTO patientExtraDataDTO ,@PathVariable String patientEmailId) throws ResourceNotFoundException{
		log.debug("Starting.. --Data Received -> ", patientExtraDataDTO + " -- " + patientEmailId);  
		patientServiceImpl.savePatientsExtraData(patientExtraDataDTO,patientEmailId);
		ResponseMessage responseMessage = new ResponseMessage("Data saved successfully ", "Patient's extra data", new Date().toString());
		return new ResponseEntity<ResponseMessage>(responseMessage,HttpStatus.OK);
	}
	
	@GetMapping("/showDataAfterlogin/{emailId}")
	public ResponseEntity<PatientSignupDTO> getPatientByEmailId(@PathVariable String emailId) throws ResourceNotFoundException{
		log.debug("Starting.. --Data Received -> ", emailId);
		PatientSignupDTO patientSignupDTO = patientServiceImpl.getPatinetByEmailId(emailId);
		return new ResponseEntity<PatientSignupDTO>(patientSignupDTO,HttpStatus.OK);
	}
	
	@GetMapping("/getAllData")
	public ResponseEntity<List<Patient>> getAllPatient(){
		log.debug("Starting.. --Data Received -> Not needed" );
		List<Patient> listOfPatient= patientServiceImpl.getAllPatient();
		return new ResponseEntity<List<Patient>>(listOfPatient, HttpStatus.OK);
	}
	
	@GetMapping("/getDataById/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Long id) throws ResourceNotFoundException{
		log.debug("Starting.. --Data Received -> ", id);
		Patient patient = patientServiceImpl.getPatientById(id);
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
	
	@GetMapping("/getDataByName/{name}")
	public ResponseEntity<Patient> getPatientByName(@PathVariable String name){
		log.debug("Starting.. --Data Received -> ", name);
		Patient patient = patientServiceImpl.getPatientByName(name);
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
	
	@PutMapping("/updatePatientData/{patientId}")
	public ResponseEntity<Patient> updatePatientDetails(@RequestBody PatientDataUpdateDTO patientDataUpdateDTO,@PathVariable Long patientId) throws ResourceNotFoundException{
		log.debug("Starting.. --Data Received -> ", patientDataUpdateDTO + " -- " + patientId);  
		Patient patient = patientServiceImpl.updatePatientData(patientDataUpdateDTO,patientId);
		return new ResponseEntity<Patient>(patient,HttpStatus.OK);
	}
	
}
