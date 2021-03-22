package com.niit.mountaingearcart.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.niit.mountaingearcart.model.category;
import com.niit.mountaingearcart.srv.category_srv;

@Controller
public class category_controller {
	@Autowired
	category_srv categorysrv;
	
	@RequestMapping(value = "/category")
	public ModelAndView category() {
		ModelAndView mv = new ModelAndView("category");
		mv.addObject("save_category", new category());
		List<category> allcategory = categorysrv.showcategory();
		
		mv.addObject("category", allcategory);
		return mv;
	}

	@ModelAttribute("save_category")
	public category getCategoryObject() {
		return new category();
	}

	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public ModelAndView savecategory(@Valid @ModelAttribute("save_category") category c,BindingResult result) {
		ModelAndView mv;
		if(result.hasErrors())
		{
			mv = new ModelAndView("category");
			return mv;
		}
		categorysrv.savecategory(c);
		mv = new ModelAndView("category");
		List<category> allcategory = categorysrv.showcategory();
		mv.addObject("category", allcategory);
		return mv;
	}

	@RequestMapping(value = "/deletecategory/{id}")
	public ModelAndView delete(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView("category");
		categorysrv.deletecategory(id);
		List<category> allcategory = categorysrv.showcategory();
		mv.addObject("category", allcategory);
		return mv;
	}

	@RequestMapping(value = "/updatecategory", method=RequestMethod.GET)
	public ModelAndView updatecategory(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("editcategory");
		System.out.println("in updatecategory id:"+id);
		category oldcategory = categorysrv.getNameById(id);
		mv.addObject("category_id", oldcategory.getCategory_id());
		mv.addObject("category_name",oldcategory.getCategory_name());
		return mv;
	}
	
	@ModelAttribute("edit_category")
	public category getCategory() {
		return new category();
	}

	@RequestMapping(value = "/editcategory", method = RequestMethod.POST)
	public ModelAndView editcategory(@Valid @ModelAttribute("edit_category") category c) {
		ModelAndView mv;
		categorysrv.updatecategory(c);
		System.out.println("in editcategory id:");
		mv = new ModelAndView("category");
		List<category> allcategory = categorysrv.showcategory();
		mv.addObject("category", allcategory);
		return mv;
	}
}
