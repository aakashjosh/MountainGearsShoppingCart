package com.niit.mountaingearcart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "userdetails")
public class userdetails implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Column(name="admin",columnDefinition = "INT default 0")
	private byte admin;
	
	
	@Column(name="user_name")
	@NotEmpty(message = "Enter a valid User Name.")
	private String user_name;
	
	@Column(name="password")
	@NotEmpty(message = "Please enter your password.")
    @Size(min = 5, max = 10, message = "Your password must between 5 and 10 characters")
	private String password;
	
	@Column(name="repeatpassword")
	@NotEmpty(message = "Please reenter your password.")
    @Size(min = 5, max = 10, message = "Your password must between 5 and 10 characters")
	private String repeatpassword;
	@Id
	@Column(name="email")
	@NotEmpty(message = "Please enter your Email address.")
    @Email(message = "Invalid Email..please enter a valid Email address.")
	private String email;
	
	@Column(name="contactnumber")
	@NotEmpty(message = "Please enter your contact details.")
	@Size(min=10,max=10,message = "Enter 10 digit contact number")
	private String contactnumber;
	
	@Column(name = "address")
	@NotEmpty(message = "Please enter your address details.")
	private String address;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getRepeatpassword() {
		return repeatpassword;
	}

	public void setRepeatpassword(String repeatpassword) {
		this.repeatpassword = repeatpassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public byte getAdmin() {
		return admin;
	}

	public void setAdmin(byte admin) {
		this.admin = admin;
	}
}
