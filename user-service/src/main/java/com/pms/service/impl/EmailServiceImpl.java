package com.pms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.pms.dto.EmailDetails;
import com.pms.service.EmailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EmailServiceImpl implements EmailService {

	@Autowired 
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}") 
	private String sender;


	@Override
	public String sendSimpleMail(String recipientEmailId, String defaultPassword, String firstname)	{

			try {
				// Creating a simple mail message
				SimpleMailMessage mailMessage = new SimpleMailMessage();

				EmailDetails emailDetails = new EmailDetails();
				emailDetails.setRecipient(recipientEmailId);
				emailDetails.setSubject("Default Password of PMS");
				emailDetails.setMsgBody("Hi "+firstname+","+System.lineSeparator()
										+"Thank you for connecting with CT-Hospital"+System.lineSeparator()
										+"Your username is : "+ recipientEmailId + System.lineSeparator()
										+"Your default password is :  " + defaultPassword + System.lineSeparator()
										+"Please login on below link and change your default password " + System.lineSeparator()
										+ "http://localhost:4200/login"+ System.lineSeparator() + System.lineSeparator()
										+ "Thanks & Regards,"+ System.lineSeparator()
										+ "City Hospital");
				
				// Setting up necessary details
				mailMessage.setFrom(sender);
				mailMessage.setTo(emailDetails.getRecipient());
				mailMessage.setSubject(emailDetails.getSubject());
				mailMessage.setText(emailDetails.getMsgBody());
				
				
				// Sending the mail
				javaMailSender.send(mailMessage);
				log.info("Mail Sent Successfully " + "to user " + recipientEmailId);
				return "Mail Sent Successfully...";
			}

			// Catch block to handle the exceptions
			catch (Exception e) {
				e.printStackTrace();
				return "Error while Sending Mail";
			}
		
	}

}
