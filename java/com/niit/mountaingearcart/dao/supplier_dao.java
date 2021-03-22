package com.niit.mountaingearcart.dao;

import java.util.List;

import com.niit.mountaingearcart.model.supplier;

public interface supplier_dao {
	public List<supplier> showsupplier();
	public supplier getNameById(String id); 
	public void savesupplier(supplier obj);	
	public void updatesupplier(supplier sup);
	public void deletesupplier(String id);
}
