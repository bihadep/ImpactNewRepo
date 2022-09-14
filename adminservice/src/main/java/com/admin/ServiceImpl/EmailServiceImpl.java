package com.admin.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.admin.model.EmailDetails;
import com.admin.service.EmailService;



@Component
public class EmailServiceImpl implements EmailService {

	@Autowired 
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}") 
	private String sender;


	@Override
	public String sendSimpleMail(EmailDetails details)	{

			try {
				// Creating a simple mail message
				SimpleMailMessage mailMessage = new SimpleMailMessage();

				// Setting up necessary details
				mailMessage.setFrom(sender);
				mailMessage.setTo(details.getRecipient());
				mailMessage.setSubject(details.getSubject());
				mailMessage.setText(details.getMsgBody());
				
				
				// Sending the mail
				javaMailSender.send(mailMessage);
				
				return "Mail Sent Successfully...";
			}

			// Catch block to handle the exceptions
			catch (Exception e) {
				e.printStackTrace();
				return "Error while Sending Mail";
			}
		
	}

}
