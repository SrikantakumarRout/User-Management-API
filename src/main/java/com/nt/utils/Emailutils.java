package com.nt.utils;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Emailutils {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendEmailMessage(String toMail,String subject,String body) throws Exception {
		boolean mailSentStatus=false;
		try {
			MimeMessage message=mailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message,true);
			helper.setTo(toMail);
			helper.setSentDate(new Date());
			helper.setSubject(subject);
			helper.setText(body,true);
			mailSender.send(message);
			mailSentStatus=true;
		}
		catch(Exception e) {
			log.error(e.getMessage());
			throw e;
		}
		return mailSentStatus;
	}

}
