package com.local.team1.persistence;

import java.util.List;

import com.local.team1.domain.BoardVo;

public interface BoardDao {
	
	// 데이터 추가
	public void create(BoardVo vo) throws Exception;
	// 데이터 읽기
	public BoardVo read(Integer s_id) throws Exception;
	// 데이터 수정/변경
	public void update(BoardVo vo) throws Exception;
	// 데이터  삭제
	public void delete(Integer s_id) throws Exception;
	
	public List<BoardVo> list(String s_cate) throws Exception;
}
