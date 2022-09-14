package com.pms.util;

import org.springframework.stereotype.Component;

@Component
public final class Constants {
	
		
	public static  String phyEmpId = "DR";
	
	public static  String NurseEmpId = "NR";
	public static  String PatientEmpId = "PT";
	
	public static final String datePattern = "dd/MM/yyyy";
	
	public static final String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	public static final String specialCharacters = "!@#$";
	public static final String numbers = "1234567890";
	
	public static final int lowercaseLength = lowerCaseLetters.length();
	public static final int capitalcaseLength = capitalCaseLetters.length();
	public static final int specialcaseLength = specialCharacters.length();
	public static final int numberLength = numbers.length();
	
	//public static final String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
	
}
