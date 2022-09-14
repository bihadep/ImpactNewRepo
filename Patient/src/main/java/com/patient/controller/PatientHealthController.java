package com.patient.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient.dto.PatientVitalDetailsDTO;
import com.patient.entity.PatientVitalDetails;
import com.patient.exceptio.ResourceNotFoundException;
import com.patient.exceptio.ResponseMessage;
import com.patient.serviceImpl.PatientHealthServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("patient/patientHealth")
public class PatientHealthController {

	@Autowired
	private PatientHealthServiceImpl patientHealthService;

	@PutMapping("/saveVitalData/{patientId}")
	public ResponseEntity<ResponseMessage> saveVitalDetails(@RequestBody PatientVitalDetails patientVitalDetails,
			@PathVariable Long patientId) throws ResourceNotFoundException {
		log.debug("Starting.. --Data Received -> ", patientVitalDetails + " -- " + patientId);
		patientHealthService.savePatientVitalDetails(patientVitalDetails, patientId);
		ResponseMessage responseMessage = new ResponseMessage("Data saved successfully", "Patient Vital Data",
				new Date().toString());
		return new ResponseEntity<>(responseMessage, HttpStatus.OK);
	}

	@GetMapping("/getVitalDataByEmailId/{patientEmailId}")
	public ResponseEntity<PatientVitalDetailsDTO> getVitalDetailsById(@PathVariable String patientEmailId)
			throws ResourceNotFoundException {
		log.debug("Starting.. --Data Received -> ", patientEmailId);
		PatientVitalDetailsDTO patientVitalDetailsDTO = patientHealthService.getPatientVitalDetailsById(patientEmailId);
		if (!ObjectUtils.isEmpty(patientVitalDetailsDTO)) {
			return new ResponseEntity<>(patientVitalDetailsDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/updateVitalData/{patientId}")
	public ResponseEntity<ResponseMessage> updateVitalDetails(
			@RequestBody PatientVitalDetailsDTO patientVitalDetailsDTO, @PathVariable Long patientId)
			throws ResourceNotFoundException {
		log.debug("Starting.. --Data Received -> ", patientVitalDetailsDTO + " -- " + patientId);
		patientHealthService.updatePatientVitalDetails(patientVitalDetailsDTO, patientId);
		ResponseMessage responseMessage = new ResponseMessage("Data updated successfully", "Patient Vital Data",
				new Date().toString());
		return new ResponseEntity<>(responseMessage, HttpStatus.OK);
	}
}
