package com.local.team1.service;

import java.util.List;

import com.local.team1.domain.FreeBoardVo;
import com.local.team1.domain.PagingDto;
import com.local.team1.domain.ReplyVo;

public interface ReplyService {
	
	// 리플 쓰기
	public void create(ReplyVo r_vo) throws Exception;
	// 리플 목록
	public List<ReplyVo> listAll(int b_num) throws Exception;
	// 리플 수정하기
	public void modify(ReplyVo r_vo) throws Exception;
	// 리플 삭제하기
	public void delete(int r_num, int b_num) throws Exception;		
}
