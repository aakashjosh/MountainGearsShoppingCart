package com.niit.mountaingearcart.dao;

import java.util.List;

import com.niit.mountaingearcart.model.product;

public interface product_dao {
	
	public boolean insertRow(product product);

	public product getRowById(String id);

	public List<product> getList();

	public List<product> getListCat(String category);

	public List<product> getlistsupp(String Supplierid);

	public List<product> getListTitle(String prdname);

	public boolean updateRow(product product);

	public boolean deleteRow(String id);
	
	public product getProductById(String id);
	
	public product getproductdetailsbyid(String id);
}
