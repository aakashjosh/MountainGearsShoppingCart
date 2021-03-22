package com.niit.mountaingearcart.srv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mountaingearcart.dao.userdetails_dao;
import com.niit.mountaingearcart.model.user;
import com.niit.mountaingearcart.model.userdetails;
@Service
@Transactional
public class userdetails_srv_impl implements userdetails_srv {
	@Autowired
	userdetails_dao userdao;

	public List<userdetails> showuserdetails() {
		return userdao.showuserdetails();
	}

	public user getdetailsbyname(String name) {
		return userdao.getdetailsbyname(name);
	}

	public void saveuserdetails(userdetails details) {
		userdao.saveuserdetails(details);

	}

	public void saveuser(String name, String password) {
		userdao.saveuser(name, password);

	}

	public void updateuserdetails(userdetails details) {
		userdao.updateuserdetails(details);

	}

	public void deleteuserdetails(String name) {
		userdao.deleteuserdetails(name);

	}

	public boolean isvaliduser(String username, String password) {
		return userdao.isvaliduser(username, password);
	}

	@Override
	public void deleteuser(String user) {
		userdao.deleteuser(user);
		
	}

}
