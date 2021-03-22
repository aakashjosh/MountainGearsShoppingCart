package com.niit.mountaingearcart.srv;

import java.util.List;

import com.niit.mountaingearcart.model.shippingdetails;

public interface shippingdetails_srv {
	
	public List<shippingdetails> getlistbyusername(String user_name);
	
	public void saveshippingdetails(shippingdetails details);
	
	public void updateshippingdetails(shippingdetails details);
	
	
}
