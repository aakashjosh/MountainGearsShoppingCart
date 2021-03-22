package com.niit.mountaingearcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class onlinetransaction {
	@Id
	@Column
	private String card_number;
	@Column
	private String cvv;
	@Column
	private String user_of_card;
	@Column
	private String password_for_card;
	@Column
	private String captcha;
	public String getCard_number() {
		return card_number;
	}
	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getUser_of_card() {
		return user_of_card;
	}
	public void setUser_of_card(String user_of_card) {
		this.user_of_card = user_of_card;
	}
	public String getPassword_for_card() {
		return password_for_card;
	}
	public void setPassword_for_card(String password_for_card) {
		this.password_for_card = password_for_card;
	}
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
}
