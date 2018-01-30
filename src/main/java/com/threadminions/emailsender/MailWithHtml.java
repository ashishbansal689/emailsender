package com.threadminions.emailsender;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailWithHtml {
	@Autowired
	JavaMailSenderImpl javaMailSenderImpl;

	public void prepareAndSendMail(String[] to, String message) {
		try {
			MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();
			MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage, true);
			mailMsg.setTo(to);
			mailMsg.setSubject("Test mail with Attachment");
			mailMsg.setText(message, true);

			javaMailSenderImpl.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
