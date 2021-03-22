package com.niit.mountaingearcart.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.niit.mountaingearcart.model.userdetails;
import com.niit.mountaingearcart.srv.userdetails_srv;

@Component
public class registrationhandler {
	@Autowired
	userdetails_srv usersrv;
	
	String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	public userdetails initflow(){
		System.out.println("inside initflow");
		return new userdetails();
}
	
	public String validateDetails(userdetails userdetails,MessageContext messageContext){
		String status = "success";
		System.out.println("userdetails  :"+userdetails);
		if(userdetails.getUser_name().isEmpty()){
			
			messageContext.addMessage(new MessageBuilder().error().source(
					"user_name").defaultText("Name cannot be Empty!!").build());
			status = "failure";
		}
		if(userdetails.getPassword().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"password").defaultText("Password cannot be Empty!!").build());
			status = "failure";
		}
	
		if(userdetails.getRepeatpassword().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"repeatpassword").defaultText("Repeat password cannot be empty!!").build());
			status = "failure";
		}
		if(!userdetails.getPassword().equals(userdetails.getRepeatpassword())){
			messageContext.addMessage(new MessageBuilder().error().source(
					"repeatpassword").defaultText("Password does not match to repeat password!!").build());
			status = "failure";
		}
		if(userdetails.getContactnumber().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"contactnumber").defaultText("Mobile cannot be Empty!!").build());
			status = "failure";
		}
		if(userdetails.getContactnumber().length()!=10){
			messageContext.addMessage(new MessageBuilder().error().source(
					"contactnumber").defaultText("Please enter a valid contact number!!").build());
			status = "failure";
		}
		if(userdetails.getEmail().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"email").defaultText("Email cannot be Empty!!").build());
			status = "failure";
		}
		if(!userdetails.getEmail().matches(EMAIL_REGEX))
		{
			messageContext.addMessage(new MessageBuilder().error().source(
					"email").defaultText("Enter valid Email address!!").build());
			status = "failure";

		}
		
		return status;
	}
	
	public String savedetails(userdetails userdetails,MessageContext messageContext)
	{
		usersrv.saveuserdetails(userdetails);
		usersrv.saveuser(userdetails.getUser_name(), userdetails.getPassword());
		return "success";
	}
	
}