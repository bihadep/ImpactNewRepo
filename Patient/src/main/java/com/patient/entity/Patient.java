package com.patient.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.patient.util.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="patient_table")
public class Patient {

	//Patient SignUp data
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientId;
	private String title;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@Email
	private String emailId;
	private String dateOfBirth;
	private String contactNumber;	
	private String password;
	
	//Auto generated Values
		private int age;
		private Boolean status = true;
		private String createdDate = LocalDate.now().format(Utils.formatter());
		private String modifiedDate = LocalDate.now().format(Utils.formatter());
		
	//Patient's extra data
	@Column(length = 50)
	private String race;
	private String ethnicity;
	@Column(length = 50)
	private String languagesKnown;
	private String homeAddress;
	private Boolean isAllergic;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<AllergicTo> allergicTo;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<EmergencyContactInfo> emergencyContactInfo;
	
		
//	@OneToOne(cascade = CascadeType.ALL)
//	private PatientVitalDetails patientVitalDetails;
//	
	@OneToMany(cascade = CascadeType.ALL)
	private List<PatientProcedure> patientProcedure;

	@OneToMany(cascade = CascadeType.ALL)
	private List<PatientDiagnosticDetails> patientDiagnosticDetails;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<PatientMedication> patientMedication;

}
