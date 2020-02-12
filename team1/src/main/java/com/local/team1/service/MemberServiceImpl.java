package com.local.team1.service;

import javax.inject.Inject;

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

}
