package com.patient.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.patient.dto.PatientSignupDTO;
import com.patient.entity.AllergicTo;
import com.patient.entity.EmergencyContactInfo;
import com.patient.entity.Patient;
import com.patient.entity.PatientDiagnosticDetails;
import com.patient.entity.PatientMedication;
import com.patient.entity.PatientProcedure;
import com.patient.exceptio.ResponseMessage;
import com.patient.serviceImpl.PatientServiceImpl;
import com.patient.util.Utils;

@WebMvcTest(controllers = PatientController.class)
//@SpringBootTest
class PatientControllerTest {

	 PatientSignupDTO patientSignupDTO;
	 Patient patient;
	 ResponseMessage responseMessage;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	private PatientServiceImpl patientServiceImpl;
	
	@BeforeEach
	void setUp() {
		
		 responseMessage = new ResponseMessage("Data saved successfully  ", "Patient's Signup data", new Date().toString());

		 List<AllergicTo> listOfAllergy = new ArrayList<>();
		listOfAllergy.add(new AllergicTo( 1l, "HH1", "Animal", "Cat", "Itching in hand", "isoform"));
		
		List<EmergencyContactInfo> listOfEmergencyContactInfo = new ArrayList<>();
		listOfEmergencyContactInfo.add(new EmergencyContactInfo(1l, "Satyajeet", "P", "Friend", "satyajeet@gmail.com", "987654321", "Pune"));
		
		List<PatientProcedure> listOfPatientProcedure = new ArrayList<>();
		listOfPatientProcedure.add(new PatientProcedure(1l, "1", "Blood test", false, LocalDate.now().format(Utils.formatter()).toString(), LocalDate.now().format(Utils.formatter()).toString()));
		
		List<PatientDiagnosticDetails> listOfPatientDiagnosticDetails = new ArrayList<>();
		listOfPatientDiagnosticDetails.add(new PatientDiagnosticDetails(1l, "HH1", "Colera", false, LocalDate.now().format(Utils.formatter()).toString(), LocalDate.now().format(Utils.formatter()).toString()));
		
		List<PatientMedication> listOfPatientMedication = new ArrayList<>();
		listOfPatientMedication.add(new PatientMedication(1l, "D1", "Dolo650", "Paracetamol", "Cipla", "Tablet", "100MG", LocalDate.now().format(Utils.formatter()).toString(), LocalDate.now().format(Utils.formatter()).toString()));
		
		patientSignupDTO = new PatientSignupDTO("Mr", "Praful", "B", "praful.b@gmail", "30/01/1998", 25, "98765432", "Praful@123");
		patient = new Patient(1l, "Mr", "Praful", "B", "praful.b@gmail", "30/01/1998", "98765432", "Praful@123", 25, true, LocalDate.now().format(Utils.formatter()).toString(), LocalDate.now().format(Utils.formatter()).toString(), "", "", "", "", true, listOfAllergy, listOfEmergencyContactInfo, listOfPatientProcedure, listOfPatientDiagnosticDetails,listOfPatientMedication);
	}
	
	@Test
	void testSavePatientSignupDetails() throws Exception {		
		
		ResponseEntity<ResponseMessage> responseEntity = ResponseEntity.ok(responseMessage);
		when(patientServiceImpl.savePatient(patientSignupDTO)).thenReturn(patient);
		
		mockMvc.perform(MockMvcRequestBuilders
				.post("/patient/saveSignupData/",patientSignupDTO)
				
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.equals(responseEntity);
	}

	@Test
	void testSavePatientDetailedData() {
	}

	@Test
	void testGetPatientByEmailId() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllPatient() {
		assertTrue(true);
	}

	@Test
	void testGetPatientById() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPatientByName() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdatePatientDetails() {
		fail("Not yet implemented");
	}

}
