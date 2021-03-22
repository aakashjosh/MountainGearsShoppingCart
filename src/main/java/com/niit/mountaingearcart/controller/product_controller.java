package com.niit.mountaingearcart.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.mountaingearcart.model.category;
import com.niit.mountaingearcart.model.supplier;
import com.niit.mountaingearcart.model.product;
import com.niit.mountaingearcart.srv.category_srv;
import com.niit.mountaingearcart.srv.product_srv;
import com.niit.mountaingearcart.srv.supplier_srv;

@Controller
public class product_controller {
	@Autowired
	product_srv productsrv;
	
	@Autowired
	category_srv categorysrv;
	
	@Autowired
	supplier_srv suppliersrv;
	
	@Autowired
	ServletContext srv;
	
	@RequestMapping(value = "/product")
	public ModelAndView product(Model model) {
		ModelAndView mv = new ModelAndView("product");
		System.out.println("Save product");
		List<product> allproduct = productsrv.getList();
		List<category> allcategory = categorysrv.showcategory();
		List<supplier> allsupplier = suppliersrv.showsupplier();
		mv.addObject("product", allproduct);
		mv.addObject("category", allcategory);
		mv.addObject("supplier", allsupplier);
		//model.addAttribute("categories", new category());
		return mv;
	}
	
	
	@ModelAttribute("save_product")
	public product constructproduct() {
		return new product();
	}

	@RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
	public ModelAndView addproduct(@Valid @ModelAttribute("save_product") product product, BindingResult result) {
		System.out.println(result.hasErrors());
		if (result.hasErrors()) {
			System.out.println(product.getProduct_id());
			System.out.println(product.getProduct_name());
			System.out.println(product.getCategory());
			System.out.println(product.getSupplier_id());
			System.out.println(product.getProduct_description());
			System.out.println(product.getProduct_price());
			System.out.println(product.getProduct_discount());
			System.out.println(product.getProduct_image());
			System.out.println("failing to save product");
			return new ModelAndView("product");
		} else {
			String path = srv.getRealPath("/");
			String res = product.getFilePath(path, srv.getContextPath());
			System.out.println(res);
			if (res == "fail"){
				System.out.println("in if statement");
				return new ModelAndView("product");}
			else {
				System.out.println("succesful getfilepath");
				try{
				productsrv.insertRow(product);
				ModelAndView mv = new ModelAndView("product");
				List<product> allproduct = productsrv.getList();
				List<category> allcategory = categorysrv.showcategory();
				List<supplier> allsupplier = suppliersrv.showsupplier();
				mv.addObject("category", allcategory);
				mv.addObject("supplier", allsupplier);
				mv.addObject("product", allproduct);
				mv.addObject("path",res);
				return mv;
				}
				catch(Exception e)
				{
					ModelAndView mv5 = new ModelAndView("exception");
					return mv5;
					}
				}
		}
	}
	
	@RequestMapping(value = "/updateproduct", method=RequestMethod.GET)
	public ModelAndView updateproduct(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("editproduct");
		System.out.println("in updateproduct id:"+id);
		product oldproduct = productsrv.getRowById(id);
		mv.addObject("product", oldproduct);
		List<category> allcategory = categorysrv.showcategory();
		List<supplier> allsupplier = suppliersrv.showsupplier();
		mv.addObject("category", allcategory);
		mv.addObject("supplier", allsupplier);
		return mv;
	}
	
	@ModelAttribute("edit_product")
	public product getproduct() {
		return new product();
	}

	@RequestMapping(value = "/editproduct", method = RequestMethod.POST)
	public ModelAndView editproduct(@Valid @ModelAttribute("edit_product") product p, BindingResult result) {
		System.out.println("inside edit product before haserror");
		if (result.hasErrors()) {
			System.out.println(p.getProduct_id());
			System.out.println(p.getProduct_name());
			System.out.println(p.getCategory());
			System.out.println(p.getSupplier_id());
			System.out.println(p.getProduct_description());
			System.out.println(p.getProduct_price());
			System.out.println(p.getProduct_discount());
			System.out.println(p.getProduct_image());
			return new ModelAndView("editproduct");
		} else {
			String path = srv.getRealPath("/");
			String res = p.getFilePath(path, srv.getContextPath());
			if (res == "fail")
				return new ModelAndView("editproduct");
			else {
				productsrv.updateRow(p);
				System.out.println("in editproduct id:");
				ModelAndView mv = new ModelAndView("product");
				List<product> allproduct = productsrv.getList();
				mv.addObject("product", allproduct);
				List<category> allcategory = categorysrv.showcategory();
				List<supplier> allsupplier = suppliersrv.showsupplier();
				mv.addObject("category", allcategory);
				mv.addObject("supplier", allsupplier);
				return mv;
			}
		}
		
	}
	@RequestMapping(value = "/deleteproduct/{id}")
	public ModelAndView delete(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView("product");
		productsrv.deleteRow(id);
		List<product> allproduct = productsrv.getList();
		mv.addObject("product", allproduct);
		List<category> allcategory = categorysrv.showcategory();
		List<supplier> allsupplier = suppliersrv.showsupplier();
		mv.addObject("category", allcategory);
		mv.addObject("supplier", allsupplier);
		return mv;
	}
	
}
