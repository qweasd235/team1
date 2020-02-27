package com.local.team1.domain;

import java.sql.Timestamp;

public class MemberVo {
 
	private String mem_id;
	private String mem_pw;
	private String mem_name;
	private Timestamp mem_join_date;
	private String mem_pic;
	private String mem_email;
	private String auth_key;
	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MemberVo(String mem_id, String mem_pw, String mem_name, Timestamp mem_join_date, String mem_pic,
			String mem_email, String auth_key) {
		super();
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.mem_join_date = mem_join_date;
		this.mem_pic = mem_pic;
		this.mem_email = mem_email;
		this.auth_key = auth_key;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pw() {
		return mem_pw;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public Timestamp getMem_join_date() {
		return mem_join_date;
	}

	public void setMem_join_date(Timestamp mem_join_date) {
		this.mem_join_date = mem_join_date;
	}

	public String getMem_pic() {
		return mem_pic;
	}

	public void setMem_pic(String mem_pic) {
		this.mem_pic = mem_pic;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getAuth_key() {
		return auth_key;
	}

	public void setAuth_key(String auth_key) {
		this.auth_key = auth_key;
	}

	@Override
	public String toString() {
		return "MemberVo [mem_id=" + mem_id + ", mem_pw=" + mem_pw + ", mem_name=" + mem_name + ", mem_join_date="
				+ mem_join_date + ", mem_pic=" + mem_pic + ", mem_email=" + mem_email + ", auth_key=" + auth_key + "]";
	}
	
	
}
