package com.niit.mountaingearcart.srv;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mountaingearcart.dao.cart_dao;
import com.niit.mountaingearcart.model.cart;


@Service
@Transactional
public class cart_srv_impl implements cart_srv {
	
@Autowired                    
cart_dao cartdao;
	
	public List<cart> getwholecart(String username) {
		return cartdao.getwholecart(username);
	}

	public void savecart(cart obj) {
		cartdao.savecart(obj);

	}

	public void updatecart(cart cart) {
		cartdao.updatecart(cart);

	}

	public void deletecart(String id) {
		cartdao.deletecart(id);

	}

	public double gettotalamount(String user_name) {
		return cartdao.gettotalamount(user_name);
	}

	public void updatebyid(String id) {
		cartdao.updatebyid(id);
		
	}

	public cart getproductdetail(String id) {
		return cartdao.getproductdetail(id);
	}

}
