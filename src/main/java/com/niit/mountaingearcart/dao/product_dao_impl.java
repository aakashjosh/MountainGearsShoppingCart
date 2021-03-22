package com.niit.mountaingearcart.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.mountaingearcart.model.product;

@Repository
public class product_dao_impl implements product_dao {
@Autowired
private SessionFactory sessionFactory;


product product;
	public boolean insertRow(product product) {
		sessionFactory.getCurrentSession().save(product);
		return true;
	}

	public product getRowById(String id) {
		return (product)sessionFactory.getCurrentSession().get(product.class, id);
	}

	
	@SuppressWarnings("unchecked")
	public List<product> getList() {
		return (List<product>) sessionFactory.getCurrentSession().createQuery("from product").list();
	}

	@SuppressWarnings("unchecked")
	public List<product> getListCat(String category) {
		return (List<product>) sessionFactory.getCurrentSession().createQuery("From product where category = '" + category+"'").list();
	}

	@SuppressWarnings("unchecked")
	public List<product> getlistsupp(String Supplierid) {
		return (List<product>) sessionFactory.getCurrentSession().createQuery("From product where supplier_id = '" + Supplierid+"'").list();
	}

	@SuppressWarnings("unchecked")
	public List<product> getListTitle(String prdname) {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(product.class);
		cr.add(Restrictions.ilike("product_name", "%" + prdname + "%"));
		return cr.list();
	}

	public boolean updateRow(product product) {
		sessionFactory.getCurrentSession().update(product);
		sessionFactory.getCurrentSession().flush();
		return true;
	}

	public boolean deleteRow(String id) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM product WHERE product_id = '"+ id+"'").executeUpdate(); 
		return true;
	}

	@Override
	public product getProductById(String id) {
		String hql = " from product where product_id = '"+id+"'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<product> list = query.getResultList();
		
		if(list == null || list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
		
	}

	@Override
	public product getproductdetailsbyid(String id) {
	return(product)sessionFactory.getCurrentSession().createQuery("from product where product_id = '"+id+"'");
	}

	
	
}
