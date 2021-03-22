package com.niit.mountaingearcart.srv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mountaingearcart.dao.category_dao;
import com.niit.mountaingearcart.model.category;

@Service
@Transactional
public class category_srv_impl implements category_srv {

	@Autowired
	category_dao catdao;
	
	public List<category> showcategory() {
		return catdao.showcategory();
	}

	public category getNameById(String id) {
		return catdao.getNameById(id);
	}

	public void savecategory(category obj) {
		catdao.savecategory(obj);

	}

	public void updatecategory(category sup) {
		catdao.updatecategory(sup);
	}

	public void deletecategory(String id) {
		catdao.deletecategory(id);

	}

}
