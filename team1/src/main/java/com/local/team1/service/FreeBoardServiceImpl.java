package com.local.team1.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.local.team1.domain.FreeBoardVo;
import com.local.team1.persistence.FreeBoardDao;

@Service
public class FreeBoardServiceImpl implements FreeBoardService {
	
	@Inject
	private FreeBoardDao dao;

	@Override
	public void create(FreeBoardVo fb_vo) throws Exception {
		dao.create(fb_vo);
	}

	@Override
	public List<FreeBoardVo> listAll() throws Exception {
//		List<FreeBoardVo> list = dao.listAll();
		
		return dao.listAll();
	}

	@Override
	public FreeBoardVo read(int b_num) throws Exception {
		return dao.read(b_num);
	}

}
