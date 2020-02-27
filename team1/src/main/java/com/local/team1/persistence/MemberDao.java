package com.local.team1.persistence;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.local.team1.domain.MemberVo;

public interface MemberDao {
		
	//회원가입
	public void insertMember(MemberVo vo) throws Exception;
	//회원가입시 아이디 체크
	public int readMember(String mem_id) throws Exception;
	//로그인
	public MemberVo readWithPw(String mem_id, String mem_pw) throws Exception;
	//회원정보 가져오기
	public MemberVo readMemInfo(String mem_id) throws Exception;
	//회원정보 변경
	public void updateMember(MemberVo vo) throws Exception;
	// 프로필 사진 변경없이 회원정보 변경
	public void updateNopic(MemberVo vo) throws Exception;
	// 비밀번호 변경 시 비밀번호 체크
	public int readPw(String mem_pw) throws Exception;
	// 비밀번호 변경
	public int update_pw(String mem_pw, String mem_id) throws Exception;
	// 프로필 사진 삭제
	public void deletePic(String mem_id) throws Exception;
	// 권한키
//	public void createAuthKey(String mem_email, String auth_key) throws Exception;
	// 이메일 권한 인증
	public void verifyMember(MemberVo vo) throws Exception;
}
