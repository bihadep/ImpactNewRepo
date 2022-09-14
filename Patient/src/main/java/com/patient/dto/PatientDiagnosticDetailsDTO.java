package com.patient.dto;

import java.util.List;

import com.patient.entity.PatientDiagnosticDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDiagnosticDetailsDTO {

	private List<PatientDiagnosticDetails> ListOfpatientDiagnosticDetails;
}
