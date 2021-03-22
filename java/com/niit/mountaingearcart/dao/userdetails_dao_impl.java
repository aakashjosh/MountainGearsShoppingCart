package com.niit.mountaingearcart.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.mountaingearcart.model.user;
import com.niit.mountaingearcart.model.userdetails;
@Repository
public class userdetails_dao_impl implements userdetails_dao {
	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	public List<userdetails> showuserdetails() {
		return (List<userdetails>)sessionFactory.getCurrentSession().createQuery("from userdetails").list();
	}

	public user getdetailsbyname(String name) {
		return (user) sessionFactory.getCurrentSession().get(user.class, new String(name));
	}

	public void deleteuser(String user) {
		sessionFactory.getCurrentSession().createQuery("delete from user where username ='"+user+"'").executeUpdate();

	}

	public void saveuserdetails(userdetails details) {
		sessionFactory.getCurrentSession().save(details);
		sessionFactory.getCurrentSession().flush();

	}

	public void saveuser(String name, String password) {
		user u = new user();
		u.setUser_name(name);
		u.setPassword(password);
		sessionFactory.getCurrentSession().save(u);
		sessionFactory.getCurrentSession().flush();


	}

	public void updateuserdetails(userdetails details) {
		sessionFactory.getCurrentSession().update(details);


	}

	public void deleteuserdetails(String name) {
		sessionFactory.getCurrentSession().createQuery("delete from userdetails where user_name = '"+name+"'").executeUpdate();

	}

	public boolean isvaliduser(String username, String password) {
		@SuppressWarnings("unchecked")
		List<user> userlist = sessionFactory.getCurrentSession().createQuery("select user_name from user where user_name = '"+username+"' and password = '"+password+"'").list();
		System.out.println("userlist"+userlist);
		if(!userlist.isEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
