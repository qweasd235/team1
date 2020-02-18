package com.local.team1.persistence;

import java.util.List;

import com.local.team1.domain.FreeBoardVo;
import com.local.team1.domain.PagingDto;

public interface FreeBoardDao {
	// 데이터 쓰기
	public void create(FreeBoardVo fb_vo) throws Exception;
	// 데이터 목록
	public List<FreeBoardVo> listAll(PagingDto pagingDto) throws Exception;
	// 데이터 읽기
	public FreeBoardVo read(int b_num) throws Exception;
	// 데이터 수정
	public void modify(FreeBoardVo fb_vo) throws Exception;
	// 데이터 삭제
	public void delete(int b_num) throws Exception;
	// 데이터 총 갯수
	public int totalCount(PagingDto pagingDto) throws Exception;
	
}
