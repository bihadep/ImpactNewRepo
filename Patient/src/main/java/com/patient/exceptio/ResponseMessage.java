package com.patient.exceptio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessage {

	private String message;
	private String details;
	private String timestamp;
	
}
