package com.niit.mountaingearcart.srv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mountaingearcart.dao.onlinetransaction_dao;
import com.niit.mountaingearcart.model.onlinetransaction;
@Transactional
@Service
public class onlinetransaction_srv_impl implements onlinetransaction_srv {
@Autowired
onlinetransaction_dao onlinedao;
	@Override
	public void savetrasaction(onlinetransaction onlinetransaction) {
		onlinedao.savetrasaction(onlinetransaction);

	}

	@Override
	public void blocktransaction(String user_name) {
		// TODO Auto-generated method stub

	}

}
