package com.niit.mountaingearcart.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.mountaingearcart.model.cart;
import com.niit.mountaingearcart.model.category;
import com.niit.mountaingearcart.model.product;
import com.niit.mountaingearcart.srv.cart_srv;
import com.niit.mountaingearcart.srv.category_srv;
import com.niit.mountaingearcart.srv.product_srv;


@Controller
public class addcart_controller {
	
@Autowired
cart_srv cartsrv;

@Autowired
category_srv catsrv;
@Autowired
product_srv prosrv;


@RequestMapping(value = "/addcart", method=RequestMethod.GET)
public ModelAndView addcart(@RequestParam("id") String id,HttpServletRequest request) {
	
	HttpSession session = request.getSession();
	String loggedinuser = (String)session.getAttribute("loggedinuser");
	ModelAndView mv;
	
	if (session.getAttribute("loggedinuser") == null) {
		mv = new ModelAndView("/userlogin");
		
	}
	else
	{			
	System.out.println("inside addcart"+id);
	product product = prosrv.getRowById(id);
	System.out.println("inside addcart product"+product.getProduct_name());
	cart cart = new cart();
	cart.setProduct_id(id);
	cart.setPrice(product.getProduct_price());
	cart.setProduct_name(product.getProduct_name());
	cart.setQuantity(1);
	cart.setDiscount(product.getProduct_discount());
	cart.setUser_name(loggedinuser);
	cart.setStatus(false);
	double total = (double)(product.getProduct_price()*(1-(double)(product.getProduct_discount()/100))*cart.getQuantity());
	cart.setTotal(total);
	
	cartsrv.savecart(cart);
	
	mv = new ModelAndView("index");
	
	List<category> allcategory = catsrv.showcategory();
	mv.addObject("category", allcategory);
	List<cart> cartlist = cartsrv.getwholecart(loggedinuser);
	mv.addObject("cartlist",cartlist);
	mv.addObject("cartsize",cartlist.size());
	
		}	
	return mv;
}

}
	
	
