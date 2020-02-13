package com.local.team1.domain;

public class BoardVo {
	private int s_id;
	private String s_cate;
	private String s_name;
	private String s_add;
	private String s_detail;
	private String s_pic;
	private String s_ref;

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

	@Override
	public String toString() {
		return "BoardVo [s_id=" + s_id + ", s_cate=" + s_cate + ", s_name=" + s_name + ", s_add=" + s_add
				+ ", s_detail=" + s_detail + ", s_pic=" + s_pic + ", s_ref=" + s_ref + "]";
	}

}
