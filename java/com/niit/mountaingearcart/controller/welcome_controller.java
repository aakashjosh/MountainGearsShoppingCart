package com.niit.mountaingearcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.mountaingearcart.model.category;
import com.niit.mountaingearcart.model.maildetails;
import com.niit.mountaingearcart.srv.category_srv;

@Controller
public class welcome_controller {
	@Autowired
	category_srv catsrv;

	@RequestMapping(value = "/welcome")
	public ModelAndView indexpage() {
		List<category> allcategory = catsrv.showcategory();
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("category", allcategory);
		return mv;

	}

	@ModelAttribute("save_maildetails")
	public maildetails getmaildetails() {
		return new maildetails();
	}
	@RequestMapping(value = "/contactusher",method=RequestMethod.GET)
	public ModelAndView contactus() {
		ModelAndView mv = new ModelAndView("contactforquery");

		return mv;
	}

	@RequestMapping(value = "/admin")
	public ModelAndView admin() {

		ModelAndView mv = new ModelAndView("adminpage");
		return mv;

	}

}
