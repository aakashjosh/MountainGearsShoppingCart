package com.niit.mountaingearcart.srv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mountaingearcart.dao.product_dao;
import com.niit.mountaingearcart.model.product;
@Service
@Transactional
public class product_srv_impl implements product_srv {
@Autowired  
product_dao prdDao; 
	public boolean insertRow(product product) {
		prdDao.insertRow(product);
		return false;
	}

	public product getRowById(String id) {
		return prdDao.getRowById(id);
	}

	public List<product> getList() {
		return prdDao.getList();
	}

	public List<product> getListCat(String category) {
		return prdDao.getListCat(category);
	}

	public List<product> getlistsupp(String Supplierid) {
		return prdDao.getListCat(Supplierid);
	}

	public List<product> getListTitle(String prdname) {
		return prdDao.getListTitle(prdname);
	}

	public boolean updateRow(product product) {
		return prdDao.updateRow(product);
	}

	public boolean deleteRow(String id) {
		return prdDao.deleteRow(id);
	}

	@Override
	public product getProductById(String id) {
		return prdDao.getProductById(id);
	}

}
