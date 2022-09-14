package com.patient.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.patient.exceptio.ResourceNotFoundException;
import com.patient.exceptio.ResponseMessage;
import com.patient.serviceImpl.PatientHealthServiceImpl;
import com.patient.serviceImpl.PatientReportGeneratorServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("patient/patientReportExport")
public class PatientReportGeneratorController {
	
	@Autowired
	private PatientReportGeneratorServiceImpl patientReportGeneratorServiceImpl;

	@GetMapping("/getPatientReportInPDF/{patientEmailId}")
	public void getPatientReportByMail(@PathVariable String patientEmailId,HttpServletResponse response) throws  ResourceNotFoundException, IOException, DocumentException, IllegalArgumentException, IllegalAccessException{
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
		patientReportGeneratorServiceImpl.export(patientEmailId, response);
		
//		ResponseMessage responseMessage = new ResponseMessage("Report has been sent to your mail", "Patient's data", new Date().toString());
//		return new ResponseEntity<ResponseMessage>(responseMessage,HttpStatus.OK);	
	}
}
	