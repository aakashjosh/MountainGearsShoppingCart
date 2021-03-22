package com.niit.mountaingearcart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.mountaingearcart.model.category;
import com.niit.mountaingearcart.srv.category_srv;

@Controller
public class home_controller {
	@Autowired
	category_srv catsrv;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value="/")
	public ModelAndView indexpage(HttpServletRequest request){
		List<category> allcategory = catsrv.showcategory();
		ModelAndView mv= new ModelAndView("index");
		mv.addObject("category",allcategory);
		try{
			session.setAttribute("loggedinuser",request.getUserPrincipal().getName());
		}
		catch(Exception e)
		{
			
		}
		return mv;
	}
	@RequestMapping(value="home")
	public ModelAndView home(){
		ModelAndView mv= new ModelAndView("index");
		return mv;
	}
	@RequestMapping(value = "/securelogin")
	public ModelAndView login(@RequestParam(value = "authfailed", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model, HttpServletRequest request) {
			HttpSession session = request.getSession();
		ModelAndView mv;
		if (error != null) {
			System.out.println("Errors in username and password");
			model.addAttribute("error", "Invalid username and password");
			mv = new ModelAndView("userlogin");
			return mv;
		} else if (logout != null) {
			System.out.println("logout id not equal to null");
			mv = new ModelAndView("index");
			mv.addObject("loggedout", "true");
			List<category> allcategory = catsrv.showcategory();
			mv.addObject("category", allcategory);
			return mv;

		}else{
		mv = new ModelAndView("userlogin");
		try{
		if(request.getUserPrincipal().getName()!=null){
			System.out.println("empty user name");
		
			System.out.println("loggedinuser"+request.getUserPrincipal().getName());
		mv.addObject("loggedinuser", request.getUserPrincipal().getName());
		session.setAttribute("loggedinuser",request.getUserPrincipal().getName());
		}}
		catch(Exception e){}
		System.out.println("succesful in secure login--will direct to index page");
		
		return mv;}
	}
	@RequestMapping(value = "/contactushere")
	public ModelAndView contactus(){
		ModelAndView mv = new ModelAndView("contactus2");
		return mv;
	}
}
