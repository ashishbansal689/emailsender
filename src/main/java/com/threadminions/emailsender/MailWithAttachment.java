package com.threadminions.emailsender;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailWithAttachment {

	@Autowired
	JavaMailSenderImpl javaMailSenderImpl;

	public void prepareAndSendMail(String[] to, String message) {
		try 
		{
			MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();
			MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage, true);
			mailMsg.setTo(to);
			mailMsg.setSubject("Test mail with Attachment");
			mailMsg.setText(message);
			FileSystemResource file = new FileSystemResource(new File("G:/spring_boot_dbcp.png"));
			mailMsg.addAttachment("attachment.png", file);

			javaMailSenderImpl.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
