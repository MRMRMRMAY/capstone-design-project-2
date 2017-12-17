package com.simple.model;

public class Account {
	int id;
	String act_id;
	String act_pw;
	String first_name;
	String last_name;
	String email_address;
	public Account() {}
	public Account(String _act_id, String _act_pw) {
		this.act_id = _act_id;
		this.act_pw = _act_pw;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getActId() {
		return act_id;
	}
	public void setAct_Id(String act_id) {
		this.act_id = act_id;
	}
	public String getPw() {
		return act_pw;
	}
	public void setPw(String act_pw) {
		this.act_pw = act_pw;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
}
