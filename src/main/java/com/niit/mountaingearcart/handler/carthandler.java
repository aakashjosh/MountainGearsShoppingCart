package com.niit.mountaingearcart.handler;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.niit.mountaingearcart.model.cart;
import com.niit.mountaingearcart.model.shippingdetails;
import com.niit.mountaingearcart.model.userdetails;
import com.niit.mountaingearcart.srv.cart_srv;
import com.niit.mountaingearcart.srv.shippingdetails_srv;
import com.niit.mountaingearcart.srv.userdetails_srv;

@Component
public class carthandler {
	String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	
	@Autowired
	shippingdetails_srv shippingsrv;
	@Autowired
	userdetails_srv usrsrv;

	@Autowired
	cart_srv cartsrv;
	@Autowired
	HttpSession session;
	public shippingdetails initflow(){
		shippingdetails details = new shippingdetails();
		
		return details;
	}
	
	

	public String validateDetails(shippingdetails details,MessageContext messageContext){
		String status = "success";
		System.out.println(details.getSend_to());
		System.out.println(details.getContact_number());
		System.out.println(details.getAddress());
		System.out.println(details.getMode_of_payment());
		System.out.println(details.getEmail());
		if(details.getSend_to().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"send_to").defaultText("Please enter the recepient!!").build());
			status = "failure";
		}
	
		if(details.getMode_of_payment().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"mode_of_payment").defaultText("Enter the mode of payment!!").build());
			status = "failure";
		}
		
		if(details.getContact_number().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"contact_number").defaultText("Contact number cannot be Empty!!").build());
			status = "failure";
		}
		if(details.getContact_number().length()!=10){
			messageContext.addMessage(new MessageBuilder().error().source(
					"contactnumber").defaultText("Please enter a valid contact number!!").build());
			status = "failure";
		}
		if(details.getEmail().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"email").defaultText("Email cannot be Empty!!").build());
			status = "failure";
		}
		if(!details.getEmail().matches(EMAIL_REGEX))
		{
			messageContext.addMessage(new MessageBuilder().error().source(
					"email").defaultText("Enter valid Email address!!").build());
			status = "failure";

		}
		if(details.getAddress().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"address").defaultText("Address cannot be Empty!!").build());
			status = "failure";
		}
		
		return status;
	}
	public String savedetails(shippingdetails details,MessageContext messageContext)
	{
		System.out.println(details.getAddress());
		System.out.println(details.getContact_number());
		System.out.println(details.getEmail());
		System.out.println(details.getMode_of_payment());
		System.out.println(details.getSend_to());
		System.out.println(session.getAttribute("grandtotal"));
		System.out.println(session.getAttribute("loggedinuser"));
		details.setUser_name((String)session.getAttribute("loggedinuser"));
		details.setTotal_amount((Double)session.getAttribute("grandtotal"));
		shippingsrv.saveshippingdetails(details);
		List<cart> allcart = cartsrv.getwholecart((String)session.getAttribute("loggedinuser"));
		for(cart c:allcart)
		{
			c.setStatus(true);
			cartsrv.updatecart(c);
		}
		return "success";
	}
	
	
}
	