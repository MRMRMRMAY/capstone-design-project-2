package com.simple.model;

public class Account {
	int id;
	String act_id;
	String act_pw;
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
}
