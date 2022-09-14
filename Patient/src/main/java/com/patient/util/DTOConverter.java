package com.patient.util;

import java.time.LocalDate;
import java.util.List;

import com.patient.dto.PatientDataUpdateDTO;
import com.patient.dto.PatientExtraDataDTO;
import com.patient.dto.PatientSignupDTO;
import com.patient.dto.PatientVitalDetailsDTO;
import com.patient.entity.Patient;
import com.patient.entity.PatientDiagnosticDetails;
import com.patient.entity.PatientMedication;
import com.patient.entity.PatientProcedure;
import com.patient.entity.PatientVitalDetails;

public class DTOConverter {

	public static Patient PatientSignupDTOToPatient(PatientSignupDTO patientSignupDTO) {
		Patient patient = new Patient();
		patient.setTitle(patientSignupDTO.getTitle());
		patient.setFirstName(patientSignupDTO.getFirstName());
		patient.setLastName(patientSignupDTO.getLastName());
		patient.setEmailId(patientSignupDTO.getEmailId());
		patient.setDateOfBirth(patientSignupDTO.getDateOfBirth());
		patient.setAge(Utils.ageCalculate(patientSignupDTO.getDateOfBirth()));
		patient.setContactNumber(patientSignupDTO.getContactNumber());
		patient.setPassword(patientSignupDTO.getPassword());
		return patient;
	}

	public static PatientSignupDTO PatientTOPatientSignupDTO(Patient patient) {
		PatientSignupDTO patientSignupDTO= new PatientSignupDTO();
		patientSignupDTO.setTitle(patient.getTitle());
		patientSignupDTO.setFirstName(patient.getFirstName());
		patientSignupDTO.setLastName(patient.getLastName());
		patientSignupDTO.setEmailId(patient.getEmailId());
		patientSignupDTO.setDateOfBirth(patient.getDateOfBirth());
		patientSignupDTO.setAge(patient.getAge());
		patientSignupDTO.setContactNumber(patient.getContactNumber());
		return patientSignupDTO;
	}

	public static Patient patientExtraDataDTOToPatient(PatientExtraDataDTO patientExtraDataDTO, Patient patient) {
		patient.setRace(patientExtraDataDTO.getRace());
		patient.setEthnicity(patientExtraDataDTO.getEthnicity());
		patient.setLanguagesKnown(patientExtraDataDTO.getLanguagesKnown());
		patient.setHomeAddress(patientExtraDataDTO.getHomeAddress());
		patient.setEmergencyContactInfo(patientExtraDataDTO.getEmergencyContactInfo());
		patient.setIsAllergic(patientExtraDataDTO.getIsAllergic());
		patient.setAllergicTo(patientExtraDataDTO.getAllergicTo());
		return patient;
		
	}

	public static Patient PatientDataUpdateDTOToPatient(PatientDataUpdateDTO patientDataUpdateDTO, Patient patient) {
		patient.setEmailId(patientDataUpdateDTO.getEmailId());
		patient.setContactNumber(patientDataUpdateDTO.getContactNumber());
		patient.setRace(patientDataUpdateDTO.getRace());
		patient.setEthnicity(patientDataUpdateDTO.getEthnicity());
		patient.setLanguagesKnown(patientDataUpdateDTO.getLanguagesKnown());
		patient.setModifiedDate(LocalDate.now().format(Utils.formatter()));
		patient.setHomeAddress(patientDataUpdateDTO.getHomeAddress());
		return patient;
	}

	public static PatientVitalDetails patientVitalDetailsDTOToPatientVitalDetails(
			PatientVitalDetails patientVitalDetails, PatientVitalDetailsDTO patientVitalDetailsDTO) {
		patientVitalDetails.setBodyTemperature(patientVitalDetailsDTO.getBodyTemperature());
		patientVitalDetails.setHeight(patientVitalDetailsDTO.getHeight());
		patientVitalDetails.setRespiratoryRate(patientVitalDetailsDTO.getRespiratoryRate());
		patientVitalDetails.setWeight(patientVitalDetailsDTO.getBodyTemperature());
		return patientVitalDetails;
	}

	public static Patient updatePatientDiagnosticDetails(PatientDiagnosticDetails patientDiagnosticDetails,
			Patient patient) {
		int size = patient.getPatientDiagnosticDetails().size();
		List<PatientDiagnosticDetails> listOfPatientDiagnosticDetails =patient.getPatientDiagnosticDetails();
		PatientDiagnosticDetails presentPatientDiagnosticDetails = listOfPatientDiagnosticDetails.get(size-1);
		presentPatientDiagnosticDetails.setDiagnosisCode(patientDiagnosticDetails.getDiagnosisCode());
		presentPatientDiagnosticDetails.setDiagnosisDescription(patientDiagnosticDetails.getDiagnosisDescription());
		presentPatientDiagnosticDetails.setDiagnosisIsDescriptive(patientDiagnosticDetails.getDiagnosisIsDescriptive());
		presentPatientDiagnosticDetails.setUpdatedDate(LocalDate.now().format(Utils.formatter()));
		listOfPatientDiagnosticDetails.set(size-1, presentPatientDiagnosticDetails);
		patient.setPatientDiagnosticDetails(listOfPatientDiagnosticDetails);
		return patient;
	}

	public static Patient updatingPatientMedicationDetails(PatientMedication patientMedication, Patient patient) {
		List<PatientMedication> listOfPatientMedication = patient.getPatientMedication();
		int size = listOfPatientMedication.size();
		PatientMedication presentPatientMedication = listOfPatientMedication.get(size-1);
		presentPatientMedication.setDrugId(patientMedication.getDrugId());
		presentPatientMedication.setDrugBrandName(patientMedication.getDrugBrandName());
		presentPatientMedication.setDrugForm(patientMedication.getDrugForm());
		presentPatientMedication.setDrugGenericName(patientMedication.getDrugGenericName());
		presentPatientMedication.setDrugName(patientMedication.getDrugName());
		presentPatientMedication.setDrugStrength(patientMedication.getDrugStrength());
		presentPatientMedication.setUpdatedDate(LocalDate.now().format(Utils.formatter()));
		listOfPatientMedication.set(size-1, presentPatientMedication);
		patient.setPatientMedication(listOfPatientMedication);
		return patient;
	}

	public static Patient updatePatientProcedureConversion(Patient patient, PatientProcedure patientProcedure) {
		int size = patient.getPatientProcedure().size();
		List<PatientProcedure> listOfPatientProcedure = patient.getPatientProcedure();
		PatientProcedure presentPatientProcedure = listOfPatientProcedure.get(size-1);
		presentPatientProcedure.setProcedureCode(patientProcedure.getProcedureCode());
		presentPatientProcedure.setProcedureDescription(patientProcedure.getProcedureDescription());
		presentPatientProcedure.setProcedureIsDescriptive(patientProcedure.getProcedureIsDescriptive());
		presentPatientProcedure.setUpdatedDate(LocalDate.now().format(Utils.formatter()));
		listOfPatientProcedure.set(size-1, presentPatientProcedure);
		patient.setPatientProcedure(listOfPatientProcedure);
		return patient;
	}

	public static PatientVitalDetailsDTO patientVitalDetailsToPatientVitalDetailsDTO(
			PatientVitalDetails patientVitalDetails) {

		PatientVitalDetailsDTO PatientVitalDetailsDTO = new PatientVitalDetailsDTO();
		PatientVitalDetailsDTO.setBodyTemperature(patientVitalDetails.getBodyTemperature());
		PatientVitalDetailsDTO.setHeight(patientVitalDetails.getHeight());
		PatientVitalDetailsDTO.setWeight(patientVitalDetails.getWeight());
		PatientVitalDetailsDTO.setRespiratoryRate(patientVitalDetails.getRespiratoryRate());
		return PatientVitalDetailsDTO;
	}
}
