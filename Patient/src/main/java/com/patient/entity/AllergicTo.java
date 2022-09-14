package com.patient.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AllergicTo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serialNumber;
	private String allergyId;
	private String allergyType;
	private String allergyName;
	private String allergyDescription;
	private String allergyClinicalInfo;

}
