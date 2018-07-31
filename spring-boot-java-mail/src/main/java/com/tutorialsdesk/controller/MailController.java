package com.tutorialsdesk.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

	@Autowired
	private JavaMailSender mailSender;

	@GetMapping("/sendEmail")
	public String SendEmail() {

		try {

			sendEmail();

			return "Email Sent!";

		} catch (Exception ex) {

			ex.printStackTrace();
			
			return "Error in sending email: " + ex;

		}

	}

	private void sendEmail() throws Exception {
		
		MimeMessage message = mailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom("phsharma@oneshield.com");
		
		helper.setTo("phsharma@oneshield.com");
		
		helper.setText("This is test email, Please ignore!");
		
		helper.setSubject("Test email");

		mailSender.send(message);
	}

}
