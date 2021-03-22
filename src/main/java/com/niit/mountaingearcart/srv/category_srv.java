package com.niit.mountaingearcart.srv;

import java.util.List;

import com.niit.mountaingearcart.model.category;

public interface category_srv {
	
	public List<category> showcategory();
	
	public category getNameById(String id); 
	
	public void savecategory(category obj);
	
	public void updatecategory(category cat);
	
	public void deletecategory(String id);
	
}
