package com.niit.mountaingearcart.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.mountaingearcart.model.supplier;
@Repository
public class supplier_dao_impl implements supplier_dao {
	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	public List<supplier> showsupplier() {
		return (List<supplier>)sessionFactory.getCurrentSession().createQuery("from supplier").list();
	}

	public supplier getNameById(String id) {
		return (supplier) sessionFactory.getCurrentSession().get(supplier.class, new String(id));
	}

	public void savesupplier(supplier obj) {
		sessionFactory.getCurrentSession().save(obj);
		sessionFactory.getCurrentSession().flush();

	}

	public void updatesupplier(supplier sup) {
		sessionFactory.getCurrentSession().update(sup);

	}

	public void deletesupplier(String id) {
		sessionFactory.getCurrentSession().createQuery("delete from supplier where supplier_id = '"+id+"'").executeUpdate();

	}

}
