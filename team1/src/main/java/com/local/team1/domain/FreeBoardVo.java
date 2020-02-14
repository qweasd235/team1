package com.local.team1.domain;

import java.sql.Timestamp;

public class FreeBoardVo {
	private int b_num;
	private String b_title;
	private String b_content;
	private String b_writer;
	private Timestamp b_regdate;
	private int b_read_count;
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
	
	@Override
	public String toString() {
		return "freeBoardVo [b_num=" + b_num + ", b_title=" + b_title + ", b_content=" + b_content + ", b_writer="
				+ b_writer + ", b_regdate=" + b_regdate + ", b_read_count=" + b_read_count + "]";
	}
	
	
}
