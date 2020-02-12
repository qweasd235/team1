package com.local.team1.service;

import com.local.team1.domain.LoginDto;
import com.local.team1.domain.MemberVo;

public interface MemberService {

	// 로그인
	public MemberVo login(LoginDto loginDto) throws Exception; 
	// 회원가입 
	public void join(MemberVo vo) throws Exception;
}
