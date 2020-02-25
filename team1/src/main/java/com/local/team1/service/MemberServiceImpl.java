package com.local.team1.service;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.local.team1.domain.LoginDto;
import com.local.team1.domain.MemberVo;
import com.local.team1.persistence.MemberDao;
@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDao memberDao;

	@Override
	public MemberVo login(LoginDto loginDto) throws Exception {
		return memberDao.readWithPw(loginDto.getMem_id(), loginDto.getMem_pw());
	}

	@Override
	public void join(MemberVo vo) throws Exception {
		memberDao.insertMember(vo);
	}

	@Override
	public int CheckId(String mem_id) throws Exception {
		return memberDao.readMember(mem_id);
	}

	@Override
	public void modifyMember(MemberVo vo) throws Exception {
		memberDao.updateMember(vo);
		
		
	}

	@Override
	public void modifyNopic(MemberVo vo) throws Exception {
		memberDao.updateNopic(vo);
		
	}

	@Override
	public MemberVo readMemInfo(String mem_id) throws Exception {
		return memberDao.readMemInfo(mem_id);
	}

	

}
