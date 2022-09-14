package com.patient.serviceImpl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.DocumentException;
import com.patient.dto.PatientVitalDetailsDTO;
import com.patient.entity.Patient;
import com.patient.entity.PatientVitalDetails;
import com.patient.exceptio.ResourceNotFoundException;
import com.patient.repository.PatientRepository;
import com.patient.repository.PatientVitalDetailsRepository;
import com.patient.util.PatientReportGeneratorInPDF;

@Service
public class PatientReportGeneratorServiceImpl {

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private PatientVitalDetailsRepository patientReportGeneratorServiceImpl;
	
	@Autowired
	private PatientReportGeneratorInPDF emailServiceImpl;
	
	@Autowired
	private PatientHealthServiceImpl patientHealthServiceImpl;
	
	public void export(String patientEmailId,HttpServletResponse response) throws ResourceNotFoundException, DocumentException, IOException, IllegalArgumentException, IllegalAccessException {
		Patient patient = patientRepository.findByEmailId(patientEmailId)
				.orElseThrow(()-> new ResourceNotFoundException("Patient", "Patient Email-ID", patientEmailId));
		
//		PatientVitalDetails patientVitalDetails = patientReportGeneratorServiceImpl.findByPatientId(patientId)
//				.orElseThrow(()-> new ResourceNotFoundException("Patient", "Patient ID", patientId));
		  	
		PatientVitalDetailsDTO patientVitalDetailsDTO = patientHealthServiceImpl.getPatientVitalDetailsById(patientEmailId);
		
		emailServiceImpl.sendPatientReport(patient, response,patientVitalDetailsDTO);
		}
}
