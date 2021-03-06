package com.local.team1.service;

import java.util.List;

import com.local.team1.domain.MarkVo;

public interface MarkService {

	// 데이터 추가
	public void create(MarkVo vo) throws Exception;

	// 데이터 목록
	public List<MarkVo> markList(int s_id) throws Exception;

	// 데이터 삭제
	public void markDelete(int s_id, int m_id) throws Exception;

	// 데이터 갯수
	public int totalMark(int s_id) throws Exception;

	// 데이터 평균
	public double avgMark(int s_id) throws Exception;
	
	//데이터 수정
	public void editMark(MarkVo vo) throws Exception;
}
