package com.local.team1.persistence;

import com.local.team1.domain.MemberVo;

public interface MemberDao {
		
	//회원가입
	public void insertMember(MemberVo vo) throws Exception;
	//회원가입시 아이디 체크
	public int readMember(String mem_id) throws Exception;
	//로그인
	public MemberVo readWithPw(String mem_id, String mem_pw) throws Exception;
}
