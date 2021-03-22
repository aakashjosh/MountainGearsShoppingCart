package com.niit.mountaingearcart.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="cart")
public class cart {
	@Id
	@Column
	@GeneratedValue
	private String id;
	
	private String product_id;


	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	@Column
	@GeneratedValue
	private String order_id;
	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	
	@Column
	private boolean status;
	
	@Column
	private int price;
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = new Date();
	}
	@Column
	private Date date;
	@Column
	@NotEmpty(message="Enter a valid product name.")
	private String product_name;
	@Column
	@NotEmpty(message="Enter a valid user name.")
	private String user_name;
	@Column
	private int discount;
	@Column
	private int quantity;
	@Column
	private double total;
	public cart(){}
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
