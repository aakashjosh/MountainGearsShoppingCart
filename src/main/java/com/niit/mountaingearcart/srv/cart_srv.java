package com.niit.mountaingearcart.srv;

import java.util.List;

import com.niit.mountaingearcart.model.cart;

public interface cart_srv {

	public List<cart> getwholecart(String username);
	
	public void savecart(cart obj);
	
	public void updatecart(cart cart);
	
	public void deletecart(String id);
	
	public double gettotalamount(String user_name);
	
	public void updatebyid(String id);
	
	public cart getproductdetail(String id);
}
