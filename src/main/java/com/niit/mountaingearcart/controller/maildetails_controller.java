/*package com.niit.mountaingearcart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.mountaingearcart.model.maildetails;
import com.niit.mountaingearcart.srv.maildetails_srv;

@Controller
public class maildetails_controller {
@Autowired
maildetails_srv maildet;
	@ModelAttribute("save_maildetails")
	public maildetails getmaildetails() {
		return new maildetails();
	}
	
	@RequestMapping(value = "/savemaildetails",method = RequestMethod.POST)
	public ModelAndView savemail(@Valid @ModelAttribute("save_maildetails") maildetails m,BindingResult result, Model model) {
		
		if(result.hasErrors())
		{
		ModelAndView mv = new ModelAndView("index");
			return mv;
		}
	
maildet.savedetails(m);
ModelAndView mv2 = new ModelAndView("index");
return mv2;

}}
*/