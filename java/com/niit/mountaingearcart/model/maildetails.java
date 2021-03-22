package com.niit.mountaingearcart.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class maildetails {
@Id
@Column
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@Column
private String subject;
@Column
private Date DOQ;
@Column
private String querytext;
@Column
private String emailid;
@Column
private String replytext;
@Column
private Date DOR;
@Column
private boolean status;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public Date getDOQ() {
	return DOQ;
}
public void setDOQ(Date dOQ) {
	DOQ = dOQ;
}
public String getQuerytext() {
	return querytext;
}
public void setQuerytext(String querytext) {
	this.querytext = querytext;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getReplytext() {
	return replytext;
}
public void setReplytext(String replytext) {
	this.replytext = replytext;
}
public Date getDOR() {
	return DOR;
}
public void setDOR(Date dOR) {
	DOR = dOR;
}
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}


}
