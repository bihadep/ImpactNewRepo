package com.patient.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PatientVitalDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String height;
	private String weight;
	private String bodyTemperature;
	private String respiratoryRate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patientId")
	private Patient patient;
	
}
