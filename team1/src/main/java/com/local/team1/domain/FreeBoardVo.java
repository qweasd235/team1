package com.local.team1.domain;

import java.sql.Timestamp;

public class FreeBoardVo {
	private int b_num;
	private String b_title;
	private String b_content;
	private String b_writer;
	private Timestamp b_regdate;
	private int b_read_count;
	private String b_pic;
	private int b_ref;
	private int b_step;
	private int b_level;
	private int r_count;
	
	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_writer() {
		return b_writer;
	}
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	public Timestamp getB_regdate() {
		return b_regdate;
	}
	public void setB_regdate(Timestamp b_regdate) {
		this.b_regdate = b_regdate;
	}
	public int getB_read_count() {
		return b_read_count;
	}
	public void setB_read_count(int b_read_count) {
		this.b_read_count = b_read_count;
	}
	public String getB_pic() {
		return b_pic;
	}
	public void setB_pic(String b_pic) {
		this.b_pic = b_pic;
	}
	public int getB_ref() {
		return b_ref;
	}
	public void setB_ref(int b_ref) {
		this.b_ref = b_ref;
	}
	public int getB_step() {
		return b_step;
	}
	public void setB_step(int b_step) {
		this.b_step = b_step;
	}
	public int getB_level() {
		return b_level;
	}
	public void setB_level(int b_level) {
		this.b_level = b_level;
	}
	public int getR_count() {
		return r_count;
	}
	public void setR_count(int r_count) {
		this.r_count = r_count;
	}
	
	@Override
	public String toString() {
		return "FreeBoardVo [b_num=" + b_num + ", b_title=" + b_title + ", b_content=" + b_content + ", b_writer="
				+ b_writer + ", b_regdate=" + b_regdate + ", b_read_count=" + b_read_count + ", b_pic=" + b_pic
				+ ", b_ref=" + b_ref + ", b_step=" + b_step + ", b_level=" + b_level + ", r_count=" + r_count + "]";
	}
	
	
	
	
	
	
	
	
	
}
