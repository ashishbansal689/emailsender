package com.threadminions.emailsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ASHISH
 *
 */
@SpringBootApplication
public class SpringBootConfig implements CommandLineRunner 
{

	@Autowired
	MailWithSimpleMessage mailWithSimpleMessage;
	
	@Autowired
	MailWithAttachment mailWithAttachment;
	
	@Autowired
	MailWithHtml mailWithHtml;
	
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringBootConfig.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception 
	{
		String[] to = {"<email-id>"};
		
		mailWithSimpleMessage.prepareAndSendMail(to, "Hello, This is simple email from threadminions");
		mailWithAttachment.prepareAndSendMail(to, "This is an email with attachments from threadminions");
		mailWithHtml.prepareAndSendMail(to,"<h1>This is an email with attachments from threadminions</h1>");
		
	}
}
