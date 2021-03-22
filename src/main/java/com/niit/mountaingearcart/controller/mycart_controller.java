package com.niit.mountaingearcart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.niit.mountaingearcart.model.cart;
import com.niit.mountaingearcart.model.product;
import com.niit.mountaingearcart.srv.cart_srv;
import com.niit.mountaingearcart.srv.product_srv;
import com.niit.mountaingearcart.srv.userdetails_srv;

@Controller
public class mycart_controller {
@Autowired
product_srv prosrv;
@Autowired
cart_srv cartsrv;
@Autowired
userdetails_srv usrsrv;


@RequestMapping(value = "/add_cart", method = RequestMethod.GET)
public ModelAndView mycart(HttpServletRequest request){
	HttpSession session= request.getSession();
	double grandtotal=0;
	ModelAndView mv = new ModelAndView("mycart");
	mv.addObject("cart", new cart());
	System.out.println("In add cart controller");
	String loggedinuser = (String)session.getAttribute("loggedinuser");
	List<cart> cartlist = cartsrv.getwholecart(loggedinuser);
	System.out.println("cart controller");
	mv.addObject("cartlist",cartsrv.getwholecart(loggedinuser));
	mv.addObject("totalamount",cartsrv.gettotalamount(loggedinuser));
	mv.addObject("displaycart","true");
	for(int i = 0;i<=cartlist.size()-1;i++)
	{
		grandtotal = grandtotal+cartlist.get(i).getTotal();
		System.out.println(grandtotal);
	}
	mv.addObject("grandtotal", grandtotal);
	System.out.println("hello");
	System.out.println(grandtotal);
	session.setAttribute("grandtotal",grandtotal);
	return mv;
	
}
@RequestMapping(value = "/deletecart", method=RequestMethod.GET)
public ModelAndView deletecart(@RequestParam("id") String id,HttpServletRequest request) {
	HttpSession session = request.getSession();
	String loggedinuser = (String)session.getAttribute("loggedinuser");
	
	double grandtotal = 0;
	ModelAndView mv = new ModelAndView("mycart");
	cartsrv.deletecart(id);
	List<cart> cartlist = cartsrv.getwholecart(loggedinuser);
	
	mv.addObject("cartlist",cartsrv.getwholecart(loggedinuser));
	mv.addObject("totalamount",cartsrv.gettotalamount(loggedinuser));
	mv.addObject("displaycart","true");
	for(int i = 0;i<=cartlist.size()-1;i++)
	{
		grandtotal = grandtotal+cartlist.get(i).getTotal();
	}
	mv.addObject("grandtotal", grandtotal);
	System.out.println("hello");
	System.out.println(cartsrv.gettotalamount(loggedinuser));
	
	return mv;
}
@RequestMapping(value = "/updatequantity", method=RequestMethod.GET)
public ModelAndView updatecategory(@RequestParam("id") String id,HttpSession session) {
	
	ModelAndView mv = new ModelAndView("updatequantity");
	System.out.println("in updatequantity id:"+id);
	cart oldcart = cartsrv.getproductdetail(id);
	mv.addObject("cart_id", oldcart.getId());
	mv.addObject("cart_discount", oldcart.getDiscount());
	mv.addObject("cart_price", oldcart.getPrice());
	mv.addObject("cart_quantity", oldcart.getQuantity());
	mv.addObject("cart_productname", oldcart.getProduct_name());
	mv.addObject("username",session.getAttribute("loggedinuser"));
	mv.addObject("product_name",oldcart.getProduct_name());
	mv.addObject("Product_id",oldcart.getProduct_id());
	return mv;
}
@ModelAttribute("edit_cart")
public cart getCart() {
	return new cart();
}

@RequestMapping(value = "/editquntity", method = RequestMethod.POST)
public ModelAndView editcategory(@Valid @ModelAttribute("edit_cart") cart c,BindingResult result,Model model,HttpSession session) {
	ModelAndView mv2 = new  ModelAndView("mycart");
	try {
		model.addAttribute("Error", "Error in quantity");
		System.out.println("ID :-"+c.getProduct_id());
	
		
		//Get Product list by Product id...
		product product2 = prosrv.getRowById(c.getProduct_id());
		System.out.println(product2.getProduct_name());
		System.out.println(product2.getProduct_id());
		System.out.println(product2.getProduct_discount());
	
		double total = (double)(product2.getProduct_price()*(1-(double)(product2.getProduct_discount()/100))* c.getQuantity());
		System.out.println("Total :- "+total);
		double grandtotal=0;
		String  loggedinuser =(String) session.getAttribute("loggedinuser");
		
		c.setTotal(total);
		cartsrv.updatecart(c);
		List<cart> cartlist = cartsrv.getwholecart(loggedinuser);
		for(int i = 0;i<=cartlist.size()-1;i++)
		{
			grandtotal = grandtotal+cartlist.get(i).getTotal();
		}
	
		mv2.addObject("grandtotal", grandtotal);
		
			
	
		mv2.addObject("cartlist",cartlist);
		System.out.println("Return");
		return mv2;
	} catch (Exception e) {
		System.out.println("Catch");
		return mv2;
	}
}
}
