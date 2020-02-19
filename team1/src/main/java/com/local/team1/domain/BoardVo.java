package com.local.team1.domain;

public class BoardVo {
	private int s_id;
	private String s_cate;
	private String s_name;
	private String s_add;
	private String s_detail;
	private String s_pic;
	private String s_ref;
	private String s_tel;
	private String s_homepage;
	private String s_holiday;
	private String s_worktime;
	private String s_cost;
	
	
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_cate() {
		return s_cate;
	}
	public void setS_cate(String s_cate) {
		this.s_cate = s_cate;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_add() {
		return s_add;
	}
	public void setS_add(String s_add) {
		this.s_add = s_add;
	}
	public String getS_detail() {
		return s_detail;
	}
	public void setS_detail(String s_detail) {
		this.s_detail = s_detail;
	}
	public String getS_pic() {
		return s_pic;
	}
	public void setS_pic(String s_pic) {
		this.s_pic = s_pic;
	}
	public String getS_ref() {
		return s_ref;
	}
	public void setS_ref(String s_ref) {
		this.s_ref = s_ref;
	}
	public String getS_tel() {
		return s_tel;
	}
	public void setS_tel(String s_tel) {
		this.s_tel = s_tel;
	}
	public String getS_homepage() {
		return s_homepage;
	}
	public void setS_homepage(String s_homepage) {
		this.s_homepage = s_homepage;
	}
	public String getS_holiday() {
		return s_holiday;
	}
	public void setS_holiday(String s_holiday) {
		this.s_holiday = s_holiday;
	}
	public String getS_worktime() {
		return s_worktime;
	}
	public void setS_worktime(String s_worktime) {
		this.s_worktime = s_worktime;
	}
	public String getS_cost() {
		return s_cost;
	}
	public void setS_cost(String s_cost) {
		this.s_cost = s_cost;
	}
	@Override
	public String toString() {
		return "BoardVo [s_id=" + s_id + ", s_cate=" + s_cate + ", s_name=" + s_name + ", s_add=" + s_add
				+ ", s_detail=" + s_detail + ", s_pic=" + s_pic + ", s_ref=" + s_ref + ", s_tel=" + s_tel
				+ ", s_homepage=" + s_homepage + ", s_holiday=" + s_holiday + ", s_worktime=" + s_worktime + ", s_cost="
				+ s_cost + "]";
	}
		
	


}
