package com.local.team1.service;

import java.util.List;

import com.local.team1.domain.FreeBoardVo;
import com.local.team1.domain.PagingDto;

public interface FreeBoardService {
	// 글 쓰기
	public void create(FreeBoardVo fb_vo) throws Exception;
	// 글 목록
	public List<FreeBoardVo> listAll(PagingDto pagingDto) throws Exception;
	// 글 상세보기
	public FreeBoardVo read(int b_num) throws Exception;
	// 글 수정하기
	public void modify(FreeBoardVo fb_vo) throws Exception;
	// 글 수정(이미지 포함)
	public void modify_b_pic(FreeBoardVo fb_vo) throws Exception;
	// 글 삭제하기
	public void delete(int b_num) throws Exception;
	// 글 총 갯수
	public int totalCount(PagingDto pagingDto) throws Exception;
	
}
