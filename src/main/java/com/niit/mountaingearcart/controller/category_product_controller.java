package com.niit.mountaingearcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.mountaingearcart.model.product;
import com.niit.mountaingearcart.srv.product_srv;

@Controller
public class category_product_controller {
@Autowired
product_srv productsrv;
@RequestMapping(value = "/categoryproduct", method=RequestMethod.GET)
public ModelAndView catpro(@RequestParam("name") String name){
	ModelAndView mv = new ModelAndView("category_product");
	List<product> allcatproduct = productsrv.getListCat(name);
	mv.addObject("product", allcatproduct);
	return mv;
}
}
