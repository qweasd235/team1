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
	// 데이터 삭제 2
	public void delete2(Integer s_id) throws Exception;
	//데이터 상세보기
	public List<BoardVo> list(String s_cate, PagingDto dto) throws Exception;
	//수정 페이지 목록
	public List<BoardVo> editList(PagingDto dto) throws Exception;
	
	public void updateData(BoardVo vo) throws Exception;
	//카테고리별 총 글 갯수
	public int totalCount(String s_cate) throws Exception;
	// 명소 상세내용 보기
	public BoardVo detailContent(int s_id) throws Exception;
	//홈화면 리스트 
	public List<BoardVo> homeList() throws Exception;
	//수정화면 글갯수
	public int totalCountEdit() throws Exception;

}
