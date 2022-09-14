package com.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient.entity.Patient;
import com.patient.entity.PatientDiagnosticDetails;
import com.patient.exceptio.ResourceNotFoundException;
import com.patient.service.PatientDiagnosticService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("patient/patientDiagnostic")
public class PatientDiagnosticController {
	
	@Autowired
	private PatientDiagnosticService patientDiagnosticService;

	@PutMapping("/savePatientDiagnosticDetailsByPatientId/{patientId}")
	public ResponseEntity<Patient> savePatientDiagnosticDetails(@RequestBody List<PatientDiagnosticDetails> patientDiagnosticDetails,@PathVariable Long patientId) throws ResourceNotFoundException {
		log.debug("Starting.. --Data Received -> ", patientDiagnosticDetails + " -- " + patientId);
		Patient patient = patientDiagnosticService.savePatientDiagnosticDetails(patientDiagnosticDetails, patientId);
		return new ResponseEntity<>(patient,HttpStatus.OK);
	}
	
	@GetMapping("/getPatientDiagnosticDetailsByPatientId/{patientId}")
	public ResponseEntity<List<PatientDiagnosticDetails>> getPatientDiagnosticDetails(@PathVariable Long patientId) throws ResourceNotFoundException {
		log.debug("Starting.. --Data Received -> ",  patientId);
		List<PatientDiagnosticDetails> listOfPatientDiagnosticDetails = patientDiagnosticService.getAllPatientDiagnosticDetailsByPatientId(patientId);
		return new ResponseEntity<List<PatientDiagnosticDetails>>(listOfPatientDiagnosticDetails, HttpStatus.OK);
	}
	
	@PutMapping("/updatePatientDiagnosticDetailsByPatientId/{patientId}")
	public ResponseEntity<Patient> updatePatientDiagnosticDetails(@RequestBody PatientDiagnosticDetails patientDiagnosticDetails,@PathVariable Long patientId) throws ResourceNotFoundException {
		log.debug("Starting.. --Data Received -> ", patientDiagnosticDetails + " -- " + patientId);
		Patient patient = patientDiagnosticService.updatePatientDiagnosticDetailsByPatientId(patientDiagnosticDetails, patientId);
		return new ResponseEntity<>(patient,HttpStatus.OK);
	}
}
