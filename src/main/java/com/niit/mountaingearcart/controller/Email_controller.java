package com.niit.mountaingearcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.mountaingearcart.srv.EmailService_Impl;

public class Email_controller {
	@Autowired
	EmailService_Impl emailsend;

	@RequestMapping("/sendemailtoclient")
	public String sendAnEmail(@RequestParam("cname") String cname, @RequestParam("email") String to,
	@RequestParam("subject") String subject, @RequestParam("message") String body, Model model) 
	{
	try
	{
	emailsend.sendMail(cname, to, subject, body);
	model.addAttribute("confirmation",
	"Message has been sucessfully");
	}
	catch(Exception ex){
	model.addAttribute("confirmation",
	"Error in message sending, try again");
	}
	return "redirect:/welcome";
	}
}
