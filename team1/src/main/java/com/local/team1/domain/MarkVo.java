package com.local.team1.domain;

import java.sql.Timestamp;

public class MarkVo {
	private int m_id;
	private int s_id;
	private String mem_id;
	private int m_point;
	private String m_detail;
	private Timestamp m_reg_date;

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getM_point() {
		return m_point;
	}

	public void setM_point(int m_point) {
		this.m_point = m_point;
	}

	public String getM_detail() {
		return m_detail;
	}

	public void setM_detail(String m_detail) {
		this.m_detail = m_detail;
	}

	public Timestamp getM_reg_date() {
		return m_reg_date;
	}

	public void setM_reg_date(Timestamp m_reg_date) {
		this.m_reg_date = m_reg_date;
	}

	@Override
	public String toString() {
		return "MarkVo [m_id=" + m_id + ", s_id=" + s_id + ", mem_id=" + mem_id + ", m_point=" + m_point + ", m_detail="
				+ m_detail + ", m_reg_date=" + m_reg_date + "]";
	}

}
