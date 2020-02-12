package com.local.team1.domain;

public class LoginDto {

	private String mem_id;
	private String mem_pw;
	
	// getters/setters, toString
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
	@Override
	public String toString() {
		return "LoginDto [mem_id=" + mem_id + ", mem_pw=" + mem_pw + "]";
	}
	
}
