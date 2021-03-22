package com.niit.mountaingearcart.dao;

import java.util.List;

import com.niit.mountaingearcart.model.shippingdetails;

public interface shippingdetails_dao {

	public List<shippingdetails> getlistbyusername(String user_name);
	
	public void saveshippingdetails(shippingdetails details);
	
	public void updateshippingdetails(shippingdetails details);
	
	public void deleteshippingdetails(String user_name);
}
