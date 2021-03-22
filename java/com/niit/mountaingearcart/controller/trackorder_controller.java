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
import com.niit.mountaingearcart.srv.cart_srv;
import com.niit.mountaingearcart.srv.product_srv;
import com.niit.mountaingearcart.srv.userdetails_srv;

@Controller
public class trackorder_controller {
	@Autowired
	product_srv prosrv;
	@Autowired
	cart_srv cartsrv;
	@Autowired
	userdetails_srv usrsrv;
	
	
	@RequestMapping(value = "/trackord", method = RequestMethod.GET)
	public ModelAndView mycart(HttpServletRequest request){
		HttpSession session= request.getSession();
		if (session.getAttribute("loggedinuser") == null) {
			ModelAndView mv3 = new ModelAndView("/userlogin");
			return mv3;
			
		}
		else{
		ModelAndView mv = new ModelAndView("trackorder");
		mv.addObject("cart", new cart());
		System.out.println("In trackorder controller");
		String loggedinuser = (String)session.getAttribute("loggedinuser");
		List<cart> cartlist = cartsrv.getwholecart(loggedinuser);
		System.out.println("track controller");
		mv.addObject("cartlist",cartsrv.getwholecart(loggedinuser));
	
		
		if(cartlist.size() == 0){
			ModelAndView mv2 = new ModelAndView("exception");
			return mv2;
		}
		
		return mv;
		}
	}
	
}
