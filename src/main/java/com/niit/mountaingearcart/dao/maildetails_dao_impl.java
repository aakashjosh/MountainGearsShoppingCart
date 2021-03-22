package com.niit.mountaingearcart.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.mountaingearcart.model.maildetails;
@Repository
public class maildetails_dao_impl implements maildetails_dao {
@Autowired
SessionFactory sessionfactory;
	@Override
	public void savedetails(maildetails maildetails) {
		sessionfactory.getCurrentSession().save(maildetails);
	}

}
