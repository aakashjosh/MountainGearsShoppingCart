package com.niit.mountaingearcart.srv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mountaingearcart.dao.supplier_dao;
import com.niit.mountaingearcart.model.supplier;
@Service
@Transactional
public class supplier_srv_impl implements supplier_srv {
	@Autowired
	supplier_dao supdao;
	public List<supplier> showsupplier() {
		return supdao.showsupplier();
	}

	public supplier getNameById(String id) {
		return supdao.getNameById(id);
	}

	public void savesupplier(supplier obj) {
		supdao.savesupplier(obj);

	}

	public void updatesupplier(supplier sup) {
		supdao.updatesupplier(sup);

	}

	public void deletesupplier(String id) {
		supdao.deletesupplier(id);

	}

}
