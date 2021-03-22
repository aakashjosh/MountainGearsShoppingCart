package com.niit.mountaingearcart.srv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mountaingearcart.dao.maildetails_dao;
import com.niit.mountaingearcart.model.maildetails;
@Service
@Transactional
public class maildetails_srv_impl implements maildetails_srv {
@Autowired
maildetails_dao maildet;
	@Override
	public void savedetails(maildetails maildetails) {
		maildet.savedetails(maildetails);

	}

}
