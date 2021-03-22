package com.niit.mountaingearcart.dao;

import java.util.List;

import com.niit.mountaingearcart.model.user;
import com.niit.mountaingearcart.model.userdetails;

public interface userdetails_dao {
	
	public List<userdetails> showuserdetails();
	
	public user getdetailsbyname(String name);
	
	public void deleteuser(String user);
	
	public void saveuserdetails(userdetails details);
	
	public void saveuser(String name,String password);
	
	public void updateuserdetails(userdetails details);
	
	public void deleteuserdetails(String name);
	
	public boolean isvaliduser(String username,String password);
}
