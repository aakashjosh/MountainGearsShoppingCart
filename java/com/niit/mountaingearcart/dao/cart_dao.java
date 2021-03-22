package com.niit.mountaingearcart.dao;

import java.util.List;

import com.niit.mountaingearcart.model.cart;

public interface cart_dao {

	
	
	public List<cart> getwholecart(String username);
	
	public cart getproductdetail(String id);
	
	public void savecart(cart obj);
	
	public void updatecart(cart cart);
	
	public void deletecart(String id);
	
	public double gettotalamount(String user_name);
	
	public void updatebyid(String id);
}
