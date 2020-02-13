package com.local.team1.service;

import java.util.List;

import com.local.team1.domain.BoardVo;

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
		public List<BoardVo> listAll() throws Exception;
}