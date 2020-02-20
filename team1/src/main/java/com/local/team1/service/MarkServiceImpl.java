package com.local.team1.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.local.team1.domain.MarkVo;
import com.local.team1.persistence.MarkDao;

@Service
public class MarkServiceImpl implements MarkService {

	@Inject
	private MarkDao dao;
	
	@Override
	public void create(MarkVo vo) throws Exception {
		dao.create(vo);
	}

}
