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
import com.niit.mountaingearcart.model.supplier;
import com.niit.mountaingearcart.srv.supplier_srv;

@Controller
public class supplier_controller {
	@Autowired
	supplier_srv suppliersrv;
	
	@RequestMapping(value = "/supplier")
	public ModelAndView supplier() {
		ModelAndView mv = new ModelAndView("supplier");
		mv.addObject("save_supplier", new supplier());
		List<supplier> allsupplier = suppliersrv.showsupplier();
		mv.addObject("supplier", allsupplier);
		return mv;
	}

	@ModelAttribute("save_supplier")
	public supplier getsupplierObject() {
		return new supplier();
	}

	@RequestMapping(value = "/savesupplier", method = RequestMethod.POST)
	public ModelAndView savesupplier(@Valid @ModelAttribute("save_supplier") supplier c,  BindingResult result) {
		ModelAndView mv;
		if(result.hasErrors()){
			mv = new ModelAndView("supplier");
			return mv;
		}
		suppliersrv.savesupplier(c);
		mv = new ModelAndView("supplier");
		List<supplier> allsupplier = suppliersrv.showsupplier();
		mv.addObject("supplier", allsupplier);
		return mv;
		
	}
	
	@RequestMapping(value = "/deletesupplier/{id}")
	public ModelAndView delete(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView("supplier");
		suppliersrv.deletesupplier(id);
		List<supplier> allsupplier = suppliersrv.showsupplier();
		mv.addObject("supplier", allsupplier);
		return mv;
	}

	@RequestMapping(value = "/updatesupplier", method=RequestMethod.GET)
	public ModelAndView updatesupplier(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("editsupplier");
		supplier oldsupplier = suppliersrv.getNameById(id);
		mv.addObject("supplier", oldsupplier);
		return mv;
	}

	@ModelAttribute("edit_supplier")
	public supplier getSupplier() {
		return new supplier();
	}

	@RequestMapping(value = "/editsupplier", method = RequestMethod.POST)
	public ModelAndView editsupplier(@Valid @ModelAttribute("edit_supplier") supplier c) {
		ModelAndView mv;
		suppliersrv.updatesupplier(c);
		System.out.println("in editsupplier id:");
		mv = new ModelAndView("supplier");
		List<supplier> allsupplier = suppliersrv.showsupplier();
		mv.addObject("supplier", allsupplier);
		return mv;
	}
}
