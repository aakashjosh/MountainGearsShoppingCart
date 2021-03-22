package com.niit.mountaingearcart.srv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailService_Impl {
	@Autowired
	private MailSender mailSender;
	public void sendMail(String cname, String to, String subject, String body) 
	{
	System.out.println(cname + " " + to + " " + subject + " " + body);
	SimpleMailMessage message = new SimpleMailMessage();
	message.setTo(to);
	message.setSubject(subject);
	message.setText(body);
	mailSender.send(message);
	}

}
