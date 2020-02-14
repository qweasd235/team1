package com.local.team1.service;

import java.util.List;

import com.local.team1.domain.FreeBoardVo;

public interface FreeBoardService {
	// 글 쓰기
	public void create(FreeBoardVo fb_vo) throws Exception;
	// 글 목록
	public List<FreeBoardVo> listAll() throws Exception;
	
}
