package com.niit.mountaingearcart.srv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mountaingearcart.dao.shippingdetails_dao;
import com.niit.mountaingearcart.model.shippingdetails;
@Service
@Transactional
public class shippingdetails_srv_impl implements shippingdetails_srv {
	@Autowired
	shippingdetails_dao shippingsrv;

	public List<shippingdetails> getlistbyusername(String user_name) {
		return shippingsrv.getlistbyusername(user_name);
	}

	public void saveshippingdetails(shippingdetails details) {
		shippingsrv.saveshippingdetails(details);

	}

	public void updateshippingdetails(shippingdetails details) {
		shippingsrv.updateshippingdetails(details);

	}

}
