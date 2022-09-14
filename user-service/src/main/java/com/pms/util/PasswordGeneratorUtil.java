package com.pms.util;


import java.util.Random;

import org.springframework.stereotype.Component;



@Component
public class PasswordGeneratorUtil {
	
	
	public String generateDefaultPassword() {
		
		Random random = new Random();
		char[] password = new char[12];

		password[0] = Constants.capitalCaseLetters.charAt(random.nextInt(Constants.capitalcaseLength));
		password[1] = Constants.lowerCaseLetters.charAt(random.nextInt(Constants.lowercaseLength));
		password[2]= Constants.lowerCaseLetters.charAt(random.nextInt(Constants.lowercaseLength));
		password[3] = Constants.lowerCaseLetters.charAt(random.nextInt(Constants.lowercaseLength));
		password[4] = Constants.lowerCaseLetters.charAt(random.nextInt(Constants.lowercaseLength));
		password[5] = Constants.lowerCaseLetters.charAt(random.nextInt(Constants.lowercaseLength));
		password[6]= Constants.lowerCaseLetters.charAt(random.nextInt(Constants.lowercaseLength));
		password[7] = Constants.capitalCaseLetters.charAt(random.nextInt(Constants.capitalcaseLength));
		password[8] = Constants.specialCharacters.charAt(random.nextInt(Constants.specialcaseLength));
		password[9] = Constants.numbers.charAt(random.nextInt(Constants.numberLength));
		password[10] = Constants.numbers.charAt(random.nextInt(Constants.numberLength));
		password[11] = Constants.numbers.charAt(random.nextInt(Constants.numberLength));
		
		return String.valueOf(password);
	}
	
	
	
	
}
