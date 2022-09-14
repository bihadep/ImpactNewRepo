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

import com.patient.entity.Patient;
import com.patient.entity.PatientProcedure;
import com.patient.exceptio.ResourceNotFoundException;
import com.patient.exceptio.ResponseMessage;
import com.patient.service.PatientProcedureService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("patient/patientProcedure")
public class PatientProcedureController {
	
	@Autowired
	private PatientProcedureService patientProcedureService;

	@PostMapping("/saveDataByPatientId/{patientId}")
	public ResponseEntity<ResponseMessage> savePatientProcedureDetailsByPatientId(@RequestBody List<PatientProcedure> patientProcedure,@PathVariable Long patientId) throws ResourceNotFoundException{
		log.debug("Starting.. --Data Received -> ", patientProcedure + " -- " + patientId);
		//If required then below line will be responseBody
		 patientProcedureService.savePatientProcedureDetails(patientProcedure, patientId);
		 ResponseMessage responseMessage = new ResponseMessage("Data saved successfully", "Patient Procedure Data", new Date().toString());
		return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.CREATED);
	}
	
	@GetMapping("/getDataByPatientId/{patientId}")
	public ResponseEntity<List<PatientProcedure>> getPatientProcedureDetailsByPatientId(@PathVariable Long patientId) throws ResourceNotFoundException{
		log.debug("Starting.. --Data Received -> ",  patientId);
		List<PatientProcedure>  listOfProcedure =  patientProcedureService.getPatientProcedureDetailsByPatientId(patientId);
		return new ResponseEntity<List<PatientProcedure>>(listOfProcedure, HttpStatus.OK);
	}
	
	@PutMapping("/updateDataByPatientId/{patientId}")
	public ResponseEntity<Patient>  updatePatientProcedureDetailsByPatientId(@RequestBody PatientProcedure patientProcedure,@PathVariable Long patientId) throws ResourceNotFoundException{
		log.debug("Starting.. --Data Received -> ", patientProcedure + " -- " + patientId);
		Patient patient = patientProcedureService.updatePatientProcedureDetailsByPatientId(patientProcedure, patientId);
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
}
