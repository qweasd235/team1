package com.local.team1.persistence;

import java.util.List;

import com.local.team1.domain.FreeBoardVo;
import com.local.team1.domain.PagingDto;
import com.local.team1.domain.ReplyVo;

public interface ReplyDao {
	// 데이터 쓰기
	public void create(ReplyVo r_vo) throws Exception;
	// 데이터 목록
	public List<FreeBoardVo> listAll() throws Exception;	
	// 데이터 수정
	public void modify() throws Exception;
	// 데이터 삭제
	public void delete() throws Exception;
	
	
}
