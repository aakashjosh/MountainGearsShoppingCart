package com.niit.mountaingearcart.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table
public class shippingdetails implements Serializable {

	private static final long serialVersionUID = 1L;
	

	@Column
	private String user_name;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private String orderid;
	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	@Column
	private String send_to;
	@Column
	@Size(min= 3, max= 3, message = "Enter your 3 digit CVV Number.")
	private String cvv;
	@Column
	@Size(min= 16, max= 16, message = "Enter your 16 digit card number.")
	private String card_number;
	@Column
	private String banking_password;
	
	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public String getBanking_password() {
		return banking_password;
	}

	public void setBanking_password(String banking_password) {
		this.banking_password = banking_password;
	}

	@Column
	private String Address;
	
	@Column
	private String Email;
	
	@Column 
	private String contact_number;
	
	@Column
	private double total_amount;
	
	@Column
	private String mode_of_payment;
	
	@Column
	private Date date;
	@Column
	private String captcha;

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public Date getDate() {
		return date;
	}

	public void setDate() {
		this.date = new Date();
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getSend_to() {
		return send_to;
	}

	public void setSend_to(String send_to) {
		this.send_to = send_to;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	public String getMode_of_payment() {
		return mode_of_payment;
	}

	public void setMode_of_payment(String mode_of_payment) {
		this.mode_of_payment = mode_of_payment;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
}
