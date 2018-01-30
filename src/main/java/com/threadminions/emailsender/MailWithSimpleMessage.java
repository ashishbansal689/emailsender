package com.threadminions.emailsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class MailWithSimpleMessage {

	@Autowired
	JavaMailSenderImpl javaMailSenderImpl;
	
	public void prepareAndSendMail(String[] to, String message)
	{
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setSubject("Simple Mail");
		mailMessage.setText(message);
		try
		{
			javaMailSenderImpl.send(mailMessage);
		}
		catch(MailException e)
		{
			e.printStackTrace();
		}
		
	}
}
