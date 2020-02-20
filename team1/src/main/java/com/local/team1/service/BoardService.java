package com.local.team1.service;

import java.util.List;

import com.local.team1.domain.BoardVo;
import com.local.team1.domain.MarkVo;
import com.local.team1.domain.PagingDto;

public interface BoardService {
	
		// 글쓰기
		public void regist(BoardVo vo) throws Exception;
		
		// 글읽기
		public BoardVo read(Integer s_id) throws Exception;
		
		// 글수정
		public void modify(BoardVo vo) throws Exception;
		
		// 글삭제
		public void delete(Integer s_id) throws Exception;
		
		// 글목록
		public List<BoardVo> list(String s_cate, PagingDto dto) throws Exception;
		
		public List<BoardVo> editList(PagingDto dto) throws Exception;
		
		public void modifyNoData(BoardVo vo) throws Exception;
		//디테일 글 갯수
		public int totalCount(String s_cate) throws Exception;
		// 명소 상세보기
		public BoardVo detailContent(int s_id) throws Exception;
		//홈화면 리스트
		public List<BoardVo> homeList() throws Exception;
		//수정화면 글 갯수
		public int totalCountEdit() throws Exception;
}
