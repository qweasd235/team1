package com.local.team1.service;

import java.util.Map;

import com.local.team1.domain.LoginDto;
import com.local.team1.domain.MemberVo;

public interface MemberService {

	// 로그인
	public MemberVo login(LoginDto loginDto) throws Exception; 
	// 회원가입 
	public void join(MemberVo vo) throws Exception;
	// 회원가입시 아이디 체크
	public int CheckId(String mem_id) throws Exception;
	// 회원정보 불러오기
	public MemberVo readMemInfo(String mem_id) throws Exception;
	// 회원정보 변경
	public void modifyMember(MemberVo vo) throws Exception;
	// 프로필 사진없이 회원정보 변경
	public void modifyNopic(MemberVo vo) throws Exception;
	// 비밀번호 변경 시 비밀번호 체크
	public int CheckPw(String mem_pw) throws Exception;
	// 비밀번호 변경
	public void pw_change(String mem_pw, String mem_id) throws Exception;
	// 프로필 사진 삭제
	public void deletePic(String mem_id) throws Exception;

	
}
