package com.niit.mountaingearcart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.mountaingearcart.model.onlinetransaction;
import com.niit.mountaingearcart.model.shippingdetails;
import com.niit.mountaingearcart.model.user;
import com.niit.mountaingearcart.srv.onlinetransaction_srv;
import com.niit.mountaingearcart.srv.shippingdetails_srv;
import com.niit.mountaingearcart.srv.userdetails_srv;

@Controller
public class shipping_controller_online {

	userdetails_srv userdetsrv;
	@Autowired
	shippingdetails_srv shippdetsrv;
	@Autowired
	onlinetransaction_srv onlineserv;
	
	@RequestMapping(value = "/shippingrequest")
	
	public ModelAndView shippingdetail(HttpServletRequest request){
		HttpSession session= request.getSession();
		String loggedinuser = (String)session.getAttribute("loggedinuser");
		ModelAndView mv = new ModelAndView("shippingwithcontroller");
		mv.addObject("save_shippingdetails", new shippingdetails());
		return mv;
	}

	@ModelAttribute("save_shippingdetails")
		public shippingdetails getshippingdetailsobj(){
		return new shippingdetails();
	}
	@ModelAttribute("save_shippingdetailsonline")
	public onlinetransaction getshippingdetailsobj2(){
	return new onlinetransaction();
}
	@RequestMapping(value = "/saveshippingdetails", method= RequestMethod.POST)
	public ModelAndView savedetails(@Valid@ModelAttribute("save_shippingdetails") shippingdetails sd, BindingResult result,HttpServletRequest request){
		ModelAndView mv;
		user user = new user();
		HttpSession session= request.getSession();
		String loggedinuser = (String)session.getAttribute("loggedinuser");
		System.out.println(loggedinuser);
		System.out.println("just checking");
		
		shippingdetails ship2 = new shippingdetails();
		
		System.out.println(ship2.getOrderid());
		ship2.setSend_to(sd.getSend_to());
		ship2.setEmail(sd.getEmail());
		ship2.setContact_number(sd.getContact_number());
		ship2.setAddress(sd.getAddress());
		
		
		shippdetsrv.saveshippingdetails(ship2);
		
		System.out.println("Inside page 1");
		System.out.println(ship2.getAddress());
		System.out.println(ship2.getSend_to());
		System.out.println(ship2.getBanking_password());
		ModelAndView mv2 = new ModelAndView("payment");
			
			return mv2;

	}
	@RequestMapping(value = "/onlinetransaction")
	public ModelAndView getonlinedetails(@ModelAttribute("save_shippingdetailsonline") onlinetransaction online){
	
	ModelAndView mv2 = new ModelAndView("onlinepayment");
	mv2.addObject("save_shippingdetailsonline", new onlinetransaction());
	return mv2;
	}
	
	@RequestMapping(value= "/COD")
	public ModelAndView getCOD(){
		ModelAndView mv4= new ModelAndView("thankyou");
		return mv4;
	}
	@RequestMapping(value = "/validateonlinetransaction")
	public ModelAndView onlinevalidate(@Valid@ModelAttribute("save_shippingdetailsonline") onlinetransaction sd, BindingResult result){
		if(result.hasErrors()){
			ModelAndView mv5 = new ModelAndView("onlinepayment");
			return mv5;}
		if(!sd.getCaptcha().equals("123")){
			System.out.println("CAPTCHA:"+sd.getCaptcha());
			ModelAndView mv5 = new ModelAndView("youarenotvaliduser");
			return mv5;
		}
			onlinetransaction onlinetran = new onlinetransaction();
			onlinetran.setCaptcha(sd.getCaptcha());
			onlinetran.setCard_number(sd.getCard_number());
			onlinetran.setCvv(sd.getCvv());
			onlinetran.setPassword_for_card(sd.getPassword_for_card());
			onlinetran.setUser_of_card(sd.getUser_of_card());
			onlineserv.savetrasaction(onlinetran);
			ModelAndView mv6 = new ModelAndView("thankyou");
			return mv6;
			
			
		}
		
	}


	


