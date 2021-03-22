package com.niit.mountaingearcart.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.mountaingearcart.model.onlinetransaction;
@Repository
public class onlinetransaction_dao_impl implements onlinetransaction_dao {
	@Autowired
	SessionFactory sessionFactory;
	public void savetrasaction(onlinetransaction onlinetransaction) {
		sessionFactory.getCurrentSession().save(onlinetransaction);


	}

	public void blocktransaction(String user_name) {
		// TODO Auto-generated method stub

	}

}
