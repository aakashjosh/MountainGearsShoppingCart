package com.niit.mountaingearcart.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.mountaingearcart.model.cart;

@Repository
public class cart_dao_impl implements cart_dao {
	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	public List<cart> getwholecart(String username) {
		return(List<cart>)sessionFactory.getCurrentSession().createQuery("from cart where user_name is'"+username+"'").list();
	}
	
	public cart getproductdetail(String id) {
		return(cart)sessionFactory.getCurrentSession().get(cart.class, id);
	}

	public void savecart(cart obj) {
		sessionFactory.getCurrentSession().save(obj);

	}

	public void updatecart(cart cart) {
		sessionFactory.getCurrentSession().update(cart);

	}

	public void deletecart(String id) {
		sessionFactory.getCurrentSession().createQuery("delete from cart where id = '"+id+"'").executeUpdate();

	}

	public double gettotalamount(String user_name) {
		double sum;
		try {
			String hql ="select sum(total) from cart where user_name = '"+user_name+"' and status = "+"false";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			 sum = (Double) (query.uniqueResult());
			
			} catch (Exception e) {
			// TODO: handle exception
			 sum = 0;
				}
		

		return sum;
	}

	public void updatebyid(String id) {
		cart cart = new cart();
		cart.setId(id);
		sessionFactory.getCurrentSession().update(cart);

	}


}
