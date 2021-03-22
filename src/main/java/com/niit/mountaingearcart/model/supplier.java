package com.niit.mountaingearcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="supplier2")
public class supplier {
	@Id
	@Column(name="supplier_id")
	private String supplier_id;
	
	@Column(name="supplier_name")
	@NotEmpty(message = "Please enter a name.")
	private String supplier_name;
	
	@NotEmpty(message = "Please enter contact details.")
	@Size(min = 10, max = 10, message = "Please enter a valid contact number")
	@Column(name="supplier_contact")
	private String supplier_contact;
	
	@NotEmpty(message = "Please enter Email address.")
    @Email(message = "Invalid Email..please enter a valid Email address.")
	@Column(name="supplier_email")
	private String supplier_email;

	@NotEmpty(message = "Please enter supplier city.")
	@Column(name="supplier_city")
	private String supplier_city;
	
	@NotEmpty(message = "Please enter supplier address.")
	@Column(name="supplier_address")
	private String supplier_address;
	
	

	public String getSupplier_id() {
		return supplier_id;
	}


	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}


	public String getSupplier_name() {
		return supplier_name;
	}


	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}


	public String getSupplier_address() {
		return supplier_address;
	}


	public void setSupplier_address(String supplier_address) {
		this.supplier_address = supplier_address;
	}


	public String getSupplier_city() {
		return supplier_city;
	}


	public void setSupplier_city(String supplier_city) {
		this.supplier_city = supplier_city;
	}


	public String getSupplier_contact() {
		return supplier_contact;
	}


	public void setSupplier_contact(String supplier_contact) {
		this.supplier_contact = supplier_contact;
	}


	public String getSupplier_email() {
		return supplier_email;
	}


	public void setSupplier_email(String supplier_email) {
		this.supplier_email = supplier_email;
	}
}
