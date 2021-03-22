package com.niit.mountaingearcart.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.mountaingearcart.model.category;
@Repository
public class category_dao_impl implements category_dao {
	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	public List<category> showcategory() {
		return (List<category>)sessionFactory.getCurrentSession().createQuery("from category").list();
	}

	public category getNameById(String id) {
		return (category) sessionFactory.getCurrentSession().get(category.class, new String(id));
	}

	public void savecategory(category obj) {
		sessionFactory.getCurrentSession().save(obj);
		sessionFactory.getCurrentSession().flush();

	}

	public void updatecategory(category cat) {
		sessionFactory.getCurrentSession().update(cat);

	}

	public void deletecategory(String id) {
		sessionFactory.getCurrentSession().createQuery("delete from category where category_id = '"+id+"'").executeUpdate();

	}

}
