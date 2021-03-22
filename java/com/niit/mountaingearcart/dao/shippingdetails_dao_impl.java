package com.niit.mountaingearcart.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.mountaingearcart.model.shippingdetails;
@Repository
public class shippingdetails_dao_impl implements shippingdetails_dao {
	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	public List<shippingdetails> getlistbyusername(String user_name) {
		return (List<shippingdetails>)sessionFactory.getCurrentSession().createQuery("from shippingdetails").list();
	}

	public void saveshippingdetails(shippingdetails details) {
		sessionFactory.getCurrentSession().save(details);
		sessionFactory.getCurrentSession().flush();


	}

	public void updateshippingdetails(shippingdetails details) {
		sessionFactory.getCurrentSession().update(details);


	}

	public void deleteshippingdetails(String user_name) {
		sessionFactory.getCurrentSession().createQuery("delete from shippingdetails where user_name = '"+user_name+"'").executeUpdate();

	}

}
