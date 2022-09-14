package com.patient.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Utils {

	 public static int ageCalculate(String dateOfBirth)
	    { 
		    DateTimeFormatter formatPattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate localDate = LocalDate.parse( dateOfBirth, formatPattern);
			Period agePeriod = Period.between(localDate, LocalDate.now());
			return agePeriod.getYears();
	    }

	public static DateTimeFormatter formatter() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		return formatter;
	}
	    
}
