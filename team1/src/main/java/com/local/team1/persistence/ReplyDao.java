package com.local.team1.persistence;

import java.util.List;

import com.local.team1.domain.ReplyVo;

public interface ReplyDao {
	// 데이터 쓰기
	public void create(ReplyVo r_vo) throws Exception;
	// 데이터 목록
	public List<ReplyVo> listAll(int b_num) throws Exception;	
	// 데이터 수정
	public void modify(ReplyVo r_vo) throws Exception;
	// 데이터 삭제
	public void delete(int r_num) throws Exception;
	// 데이터 삭제 by b_num (해당 게시글의 댓글 한번에 삭제)
	public void deleteByb_num(int b_num) throws Exception;
	
}
