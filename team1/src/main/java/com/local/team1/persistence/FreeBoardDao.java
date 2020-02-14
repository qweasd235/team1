package com.local.team1.persistence;

import java.util.List;

import com.local.team1.domain.FreeBoardVo;

public interface FreeBoardDao {
	// 데이터 쓰기
	public void create(FreeBoardVo fb_vo) throws Exception;
	// 데이터 목록
	public List<FreeBoardVo> listAll() throws Exception;
	
}
