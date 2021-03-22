package com.niit.mountaingearcart.dao;

import com.niit.mountaingearcart.model.onlinetransaction;

public interface onlinetransaction_dao {

	public void savetrasaction(onlinetransaction onlinetransaction);
	
	public void blocktransaction(String user_name);
	
	
}
