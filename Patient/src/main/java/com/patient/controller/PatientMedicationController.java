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

import com.patient.entity.PatientMedication;
import com.patient.exceptio.ResourceNotFoundException;
import com.patient.exceptio.ResponseMessage;
import com.patient.service.PatientMedicationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("patient/patientMedication")
public class PatientMedicationController {
	
	@Autowired
	private PatientMedicationService patientMedicationService;

	@PostMapping("/saveDetailsByPatientId/{patientId}")
	public ResponseEntity<ResponseMessage> savePatientMedicationDetails(@RequestBody List<PatientMedication> patientMedication,
		@PathVariable Long patientId) throws ResourceNotFoundException{
		log.debug("Starting.. --Data Received -> ", patientMedication + " -- " + patientId);
		patientMedicationService.savePatientMedicationDetails(patientMedication, patientId);
		ResponseMessage responseMessage = new ResponseMessage("Data saved succeddfully", "Patient Medication Data", new Date().toString());
		return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.CREATED);
	}
	
	@GetMapping("/getDetailsByPatientId/{patientId}")
	public ResponseEntity<List<PatientMedication>> getPatientMedicationDetails(@PathVariable Long patientId) throws ResourceNotFoundException{
		log.debug("Starting.. --Data Received -> ", patientId);
		List<PatientMedication> listOfPatientMedicationData = patientMedicationService.getPatientMedicationDetails(patientId);
		return new ResponseEntity<List<PatientMedication>>(listOfPatientMedicationData, HttpStatus.OK);
	}
	
	@PutMapping("/updateDetailsByPatientId/{patientId}")
	public ResponseEntity<ResponseMessage> updatePatientMedicationDetails(@RequestBody PatientMedication patientMedication,
			@PathVariable Long patientId) throws ResourceNotFoundException{
		log.debug("Starting.. --Data Received -> ", patientMedication + " -- " + patientId);
		patientMedicationService.updatePatientMedicationDetails(patientMedication, patientId);
		ResponseMessage responseMessage = new ResponseMessage("Data updated succeddfully", "Patient Medication Data", new Date().toString());
		return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.CREATED);
	}
}
