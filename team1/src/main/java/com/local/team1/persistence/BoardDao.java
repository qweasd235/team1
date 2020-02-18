package com.local.team1.persistence;

import java.util.List;

import com.local.team1.domain.BoardVo;
import com.local.team1.domain.PagingDto;

public interface BoardDao {
	
	// 데이터 추가
	public void create(BoardVo vo) throws Exception;
	// 데이터 읽기
	public BoardVo read(Integer s_id) throws Exception;
	// 데이터 수정/변경
	public void update(BoardVo vo) throws Exception;
	// 데이터  삭제
	public void delete(Integer s_id) throws Exception;
	//데이터 상세보기
	public List<BoardVo> list(String s_cate, PagingDto dto) throws Exception;
	//수정 페이지 목록
	public List<BoardVo> editList() throws Exception;
	
	public void updateData(BoardVo vo) throws Exception;

}
