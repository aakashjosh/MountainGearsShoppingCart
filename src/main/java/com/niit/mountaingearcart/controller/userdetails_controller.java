package com.niit.mountaingearcart.controller;

import java.util.List;

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

import com.niit.mountaingearcart.model.cart;
import com.niit.mountaingearcart.model.category;
import com.niit.mountaingearcart.model.user;
import com.niit.mountaingearcart.model.userdetails;
import com.niit.mountaingearcart.srv.cart_srv;
import com.niit.mountaingearcart.srv.category_srv;
import com.niit.mountaingearcart.srv.product_srv;
import com.niit.mountaingearcart.srv.userdetails_srv;

@Controller
public class userdetails_controller {
	@Autowired
	userdetails_srv usersrv;
	@Autowired
	cart_srv cartsrv;
	@Autowired
	category_srv catsrv;
	@Autowired
	product_srv prosrv;

	@RequestMapping(value = "/loginhere", method = RequestMethod.GET)
	public String userLogin() {
		System.out.println("inside login controller");
		return "userlogin";
	}


	@RequestMapping(value = "/register")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("user_details", new userdetails());
		return mv;
	}

	@ModelAttribute("check_login")
	public user getCategoryObject() {
		return new user();
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("check_login") user usr,BindingResult result,HttpSession session) {
		System.out.println("inside login function");
		ModelAndView mv;
		if(result.hasErrors())
		{
			System.out.println("input has error");
			mv = new ModelAndView("userlogin");
			return mv;
		}
		else{
		user u;
		session.setAttribute("loggedinuser", usr.getUser_name());
		boolean isvaliduser = usersrv.isvaliduser(usr.getUser_name(), usr.getPassword());

		System.out.println("isvaliduser :" + isvaliduser);
		if (isvaliduser == true) {

			u = usersrv.getdetailsbyname(usr.getUser_name());
			mv = new ModelAndView("index");
			session.setAttribute("loggedinuser", u.getUser_name());
			mv.addObject("loggedinuser", u.getUser_name());
			if (u.getAdmin() == 1) {
				System.out.println("its admin");
				
				mv = new ModelAndView("index");
				mv.addObject("isadmin", "true");
			} else {
				mv.addObject("isadmin", "false");
				List<cart> cartlist = cartsrv.getwholecart(usr.getUser_name());
				List<category> allcategory = catsrv.showcategory();
				mv.addObject("category", allcategory);
				mv.addObject("cartsize", cartlist.size());

			}
		} else {
			mv = new ModelAndView("userlogin");
			mv.addObject("invalidcredentials", "true");
			mv.addObject("errormessage", "invalid credentials");
		}
		return mv;}

	}

	
	@RequestMapping(value = "/newregister", method = RequestMethod.GET)
	public ModelAndView new_register() {
		userdetails userdtls = new userdetails();
		ModelAndView mv = new ModelAndView("register");
		mv.addObject(userdtls);
		return mv;
	}

	@ModelAttribute("save_register")
	public userdetails getuserdetailsObject() {
		return new userdetails();
	}

	@RequestMapping(value = "/saveRegister", method = RequestMethod.POST)
	public String checkandsaveregister(@Valid @ModelAttribute("save_register") userdetails userdtls,
			BindingResult result, HttpServletRequest servletRequest) {
		if (result.hasErrors()) {
			return "register";
		} else {
			usersrv.saveuserdetails(userdtls);
			usersrv.saveuser(userdtls.getUser_name(), userdtls.getPassword());
			return "index";

		}
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("/index");
		session.invalidate();
		session = request.getSession(true);
		mv.addObject("loggedout", "true");
		return mv;
	}

}
