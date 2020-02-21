package com.local.team1.domain;

import java.sql.Timestamp;

public class ReplyVo {
	private int r_num;
	private int b_num;
	private String r_writer;
	private String r_content;
	private Timestamp r_regdate;
	private Timestamp r_update;
	private String mem_pic;
	
	public int getR_num() {
		return r_num;
	}
	public void setR_num(int r_num) {
		this.r_num = r_num;
	}
	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	public String getR_writer() {
		return r_writer;
	}
	public void setR_writer(String r_writer) {
		this.r_writer = r_writer;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public Timestamp getR_regdate() {
		return r_regdate;
	}
	public void setR_regdate(Timestamp r_regdate) {
		this.r_regdate = r_regdate;
	}
	public Timestamp getR_update() {
		return r_update;
	}
	public void setR_update(Timestamp r_update) {
		this.r_update = r_update;
	}
	public String getMem_pic() {
		return mem_pic;
	}
	public void setMem_pic(String mem_pic) {
		this.mem_pic = mem_pic;
	}
	@Override
	public String toString() {
		return "ReplyVo [r_num=" + r_num + ", b_num=" + b_num + ", r_writer=" + r_writer + ", r_content=" + r_content
				+ ", r_regdate=" + r_regdate + ", r_update=" + r_update + ", mem_pic=" + mem_pic + "]";
	}
	
	
}
