package com.niit.mountaingearcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class user {
	@Column(name = "admin",columnDefinition = "INT default 0")
	private byte admin;

	@Id
	@Column(name = "user_name")
	@NotEmpty(message = "Please enter a user name.")
	private String user_name;

	@Column(name = "password")
	@NotEmpty(message = "Please enter a password.")
	private String password;
	
	@Column(columnDefinition = "INT default 1")
	private int user_role;

	public int getUser_role() {
		return user_role;
	}

	public void setUser_role(int user_role) {
		this.user_role = user_role;
	}

	public byte getAdmin() {
		return admin;
	}

	public void setAdmin(byte admin) {
		this.admin = admin;
	}

	

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
