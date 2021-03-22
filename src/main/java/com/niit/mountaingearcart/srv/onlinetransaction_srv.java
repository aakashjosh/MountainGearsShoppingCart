package com.niit.mountaingearcart.srv;

import com.niit.mountaingearcart.model.onlinetransaction;

public interface onlinetransaction_srv {
	public void savetrasaction(onlinetransaction onlinetransaction);
	
	public void blocktransaction(String user_name);
}
