package com.patient.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.patient.util.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PatientProcedure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String procedureCode;
	private String procedureDescription;
	private Boolean procedureIsDescriptive;
	private String createdDate = LocalDate.now().format(Utils.formatter());
	private String updatedDate = LocalDate.now().format(Utils.formatter());
}
